// definition of the package in which class is placed
package pl.polsl.matrixcalculatorweb.servlets;

// packages containing class definitions
import jakarta.persistence.PersistenceException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import pl.polsl.matrixcalculatorweb.model.Calculation;
import pl.polsl.matrixcalculatorweb.model.DBManager;
import pl.polsl.matrixcalculatorweb.model.DimensionException;
import pl.polsl.matrixcalculatorweb.model.Matrix;

/**
 * A class in the 'servlets' package. It is a servlet class extending
 * HttpServlet class. It also controls the flow of the program. It displays list
 * of previously made calculations and two buttons - first leading to main page
 * (MainServlet) and second used to clear the history of calculations.
 *
 * @author Maciej-Musiał
 * @version 1.4
 */
@WebServlet(name = "HistoryServlet", urlPatterns = {"/HistoryServlet"})
public class HistoryServlet extends HttpServlet {

    /**
     * DBManager object used to get connection and operate on a database.
     */
    DBManager dbManager;
    
    /**
     * HttpSession object storing information about current user's session.
     */
    private HttpSession session;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String lastButton = "Historia";
        boolean isData = false;
        List<Calculation> calculationList = null;
        session = request.getSession();
        dbManager = (DBManager) session.getAttribute("dbManager");
        
        try {
            calculationList = dbManager.findCalculations();
        } catch(PersistenceException e) {
            processException(request, response, "Błąd podczas szukania w bazie danych!");
        }
        if(calculationList != null && !calculationList.isEmpty()) {
            isData = true;
        }
        
        lastButton = request.getParameter("button");
        if (lastButton.equals("Skasuj")) {
            try {
                clearData();
            } catch(PersistenceException e) {
                processException(request, response, "Błąd podczas usuwania danych!");
            }
            isData = false;
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Matrix Calculator</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"MainServlet\">");
            out.println("<input type=\"submit\" value=\"Powrót\" style=\"margin:10px; float:left;\" />");
            out.println("</form>");
            out.println("<form action=\"HistoryServlet\">");
            out.println("<input type=\"submit\" name=\"button\" value=\"Skasuj\" style=\"margin:10px; float:left;\" />");
            out.println("</form>");

            if (isData) {
                int counter = 0;
                for (Calculation c : calculationList) {
                    Matrix<Integer> firstMatrix = c.getFirstMatrix();
                    Matrix<Integer> secondMatrix = c.getSecondMatrix();
                    Matrix<Integer> resultMatrix = c.getResultMatrix();
                    String action = c.getOperation();

                    out.println("<h1 style=\"clear:both\">" + (counter + 1) + ". działanie:</h1>");
                    out.println("<h2>Pierwsza macierz:</h2>");
                    printMatrixTable(out, firstMatrix);
                    out.println("<h2>Druga macierz:</h2>");
                    printMatrixTable(out, secondMatrix);
                    out.println("<h2>Wynik ");
                    if (action.equals("add")) {
                        out.print("dodawania:</h2>");
                    } else if (action.equals("substract")) {
                        out.print("odejmowania:</h2>");
                    } else {
                        out.print("mnożenia:</h2>");
                    }
                    printMatrixTable(out, resultMatrix);
                    counter++;
                }
            } else {
                out.println("<h1 style=\"clear:both\">Brak rezultatów</h1>");
            }

            out.println("</body>");
            out.println("</html>");
        } catch (DimensionException e) {
            processException(request, response, e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /**
     * Method used to display the error page (ErrorServlet).
     *
     * @param request servlet request
     * @param response servlet response
     * @param message String object to be displayed inside of ErrorServlet
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void processException(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        session = request.getSession();
        session.setAttribute("errorType", message);
        getServletContext().getRequestDispatcher("/ErrorServlet").forward(request, response);
    }

    /**
     * Method used to delete history of calculations stored inside of database.
     */
    private void clearData() throws PersistenceException {
        dbManager.truncateTable("Calculation");
        dbManager.truncateTable("Matrix");
    }
    
//    /**
//     * Method used to delete history of calculations stored inside of session.
//     *
//     * @param counter int object representing number of calculations stored
//     * inside of session
//     */
//    private void removeAttributes(int counter) {
//        for (int k = 0; k < counter; k++) {
//            session.removeAttribute("firstMatrix" + k);
//            session.removeAttribute("secondMatrix" + k);
//            session.removeAttribute("resultMatrix" + k);
//            session.removeAttribute("operation" + k);
//        }
//        session.setAttribute("counter", 0);
//    }

    /**
     * Method used to print matrix tables in html code.
     *
     * @param out PrintWriter object containing the reference to response
     * @param matrix Matrix object to be displayed
     */
    private void printMatrixTable(PrintWriter out, Matrix<Integer> matrix) throws DimensionException {
        out.println("<table>");
        for (int i = 0; i < matrix.getHeight(); i++) {
            out.println("<tr style=\"border:1px solid;\">");
            for (int j = 0; j < matrix.getWidth(); j++) {
                out.println("<td style=\"border:1px solid; width: 40px; text-align:center;\">" + matrix.getMatrixValue(i, j) + "</td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");
    }
}
