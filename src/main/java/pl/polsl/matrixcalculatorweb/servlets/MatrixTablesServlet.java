// definition of the package in which class is placed
package pl.polsl.matrixcalculatorweb.servlets;

// packages containing class definitions
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * A class in the 'servlets' package. It is a servlet class extending
 * HttpServlet class. It also controls the flow of the program. It displays two
 * tables of number boxes each passing information about matrices' elements,
 * three radio buttons for choosing operation and two buttons - one leading to a
 * result of calculation (ResultServlet) and second leading to main page the
 * matrices (MainServlet).
 *
 * @author Maciej-Musiał
 * @version 1.3
 */
@WebServlet(name = "MatrixTablesServlet", urlPatterns = {"/MatrixTablesServlet"})
public class MatrixTablesServlet extends HttpServlet {

    /**
     * HttpSession object storing information about current user's session.
     */
    HttpSession session;

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

        int firstMatrixRowValue = 0;
        int firstMatrixColumnValue = 0;
        int secondMatrixRowValue = 0;
        int secondMatrixColumnValue = 0;

        try {
            firstMatrixRowValue = Integer.parseInt(request.getParameter("valueFirstMatrixRow"));
            firstMatrixColumnValue = Integer.parseInt(request.getParameter("valueFirstMatrixColumn"));
            secondMatrixRowValue = Integer.parseInt(request.getParameter("valueSecondMatrixRow"));
            secondMatrixColumnValue = Integer.parseInt(request.getParameter("valueSecondMatrixColumn"));
        } catch (NumberFormatException e) {
            processException(request, response, "Wypełnij wszystkie pola, aby móc przejść dalej!");
        }

        if (firstMatrixRowValue <= 0 || firstMatrixColumnValue <= 0 || secondMatrixRowValue <= 0 || secondMatrixColumnValue <= 0) {
            processException(request, response, "Podaj poprawne wartości wierszy lub kolumn!");
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Matrix Calculator</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"MainServlet\">");
            out.println("<input type=\"submit\" value=\"Powrót\" style=\"float:left; margin:10px;\" />");
            out.println("</form>");
            out.println("<form action=\"ResultServlet\">");
            out.println("<input type=\"submit\" value=\"Dalej\" style=\"float:left; margin:10px;\" />");
            out.println("<p style=\"clear:both;\"><input type=radio name=data value=add checked>Dodaj macierze</p>");
            out.println("<p><input type=radio name=data value=substract>Odejmij macierze</p>");
            out.println("<p><input type=radio name=data value=multiply>Pomnóż macierze</p>");
            out.println("<h2>Pierwsza macierz:</h2>");
            out.println("<input type=\"hidden\" name=valueFirstMatrixRow value=" + firstMatrixRowValue + " />");
            out.println("<input type=\"hidden\" name=valueFirstMatrixColumn value=" + firstMatrixColumnValue + " />");
            out.println("<input type=\"hidden\" name=valueSecondMatrixRow value=" + secondMatrixRowValue + " />");
            out.println("<input type=\"hidden\" name=valueSecondMatrixColumn value=" + secondMatrixColumnValue + " />");
            out.println("<p>Ilość wierszy: " + firstMatrixRowValue + "</p>");
            out.println("<p>Ilość kolumn: " + firstMatrixColumnValue + "</p>");
            printMatrixTable(out, firstMatrixRowValue, firstMatrixColumnValue, "first");
            out.println("<h2>Druga macierz:</h2>");
            out.println("<p>Ilość wierszy: " + secondMatrixRowValue + "</p>");
            out.println("<p>Ilość kolumn: " + secondMatrixColumnValue + "</p>");
            printMatrixTable(out, secondMatrixRowValue, secondMatrixColumnValue, "second");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
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
     * Method used to print matrix tables in html code.
     *
     * @param out PrintWriter object containing the reference to response
     * @param rowValue number of rows
     * @param columnValue number of columns
     * @param text String which equals 'first' or 'second' depending on matrix
     */
    private void printMatrixTable(PrintWriter out, int rowValue, int columnValue, String text) {
        out.println("<table>");
        for (int i = 0; i < rowValue; i++) {
            out.println("<tr>");
            for (int j = 0; j < columnValue; j++) {
                out.println("<td><input type=\"number\" name=" + text + "MatrixValue" + i + "_" + j + " value=\"0\" step=\"1\" style=\"width:40px;\"></td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");
    }
}
