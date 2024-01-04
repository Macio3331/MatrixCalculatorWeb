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
import pl.polsl.matrixcalculatorweb.model.Calculator;
import pl.polsl.matrixcalculatorweb.model.DimensionException;
import pl.polsl.matrixcalculatorweb.model.Matrix;
import pl.polsl.matrixcalculatorweb.model.ElementInteger;
import pl.polsl.matrixcalculatorweb.model.Calculation;
import pl.polsl.matrixcalculatorweb.model.DBManager;

/**
 * A class in the 'servlets' package. It is a servlet class extending
 * HttpServlet class. It also controls the flow of the program. It displays
 * three tables with matrices - last containing the result of calculation and a
 * button leading to main page (MainServlet).
 *
 * @author Maciej-Musiał
 * @version 1.5
 */
@WebServlet(name = "ResultServlet", urlPatterns = {"/ResultServlet"})
public class ResultServlet extends HttpServlet {

    /**
     * DBManager object used to get connection and operate on a database.
     */
    DBManager dbManager;

    /**
     * Object representing the calculator - it provides adding, substracting and
     * multiplying methods.
     */
    private final Calculator calculator = new Calculator();

    /**
     * Field representing the first matrix.
     */
    private Matrix<Integer> firstMatrix;

    /**
     * Field representing the second matrix.
     */
    private Matrix<Integer> secondMatrix;

    /**
     * Field representing the result matrix.
     */
    private Matrix<Integer> resultMatrix;

    /**
     * Field representing number of calculations.
     */
    private int counter;

    /**
     * HttpSession object storing information about current user's session.
     */
    private HttpSession session;

    /**
     * Non-parameter constructor.
     */
    public ResultServlet() {
        firstMatrix = new Matrix<>(0, 0, Integer.class);
        secondMatrix = new Matrix<>(0, 0, Integer.class);
        resultMatrix = new Matrix<>(0, 0, Integer.class);
        counter = 0;
    }

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
        String action = "";

        try {
            action = request.getParameter("data");
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
        if (action.equals("")) {
            processException(request, response, "Podaj działanie do wykonania!");
        }

        firstMatrix = new Matrix<>(firstMatrixRowValue, firstMatrixColumnValue, Integer.class);
        secondMatrix = new Matrix<>(secondMatrixRowValue, secondMatrixColumnValue, Integer.class);
        resultMatrix = new Matrix<>(0, 0, Integer.class);

        try {
            getMatrixValues(request, firstMatrix, "first");
            getMatrixValues(request, secondMatrix, "second");
            selectOperation(action);
            writeToDatabase(request, action);
        } catch (NumberFormatException e) {
            processException(request, response, "Wypełnij wszystkie pola, aby móc przejść dalej!");
        } catch (DimensionException e) {
            processException(request, response, e.getMessage());
        } catch (PersistenceException e) {
            processException(request, response, "Błąd podczas utrwalania obiektu w bazie danych!");
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Matrix Calculator</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"MainServlet\">");
            out.println("<input type=\"submit\" value=\"Powrót\" style=\"margin:10px;\" />");
            out.println("</form>");
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
     * Method used to choose opeartion based on user's choice.
     *
     * @param action String containing information about chosen operation
     * @throws DimensionException object passed over from calculator's methods
     */
    private void selectOperation(String action) throws DimensionException {
        if (action.equals("add")) {
            resultMatrix = calculator.addMatrices(firstMatrix, secondMatrix, new ElementInteger());
        } else if (action.equals("substract")) {
            resultMatrix = calculator.substractMatrices(firstMatrix, secondMatrix, new ElementInteger());
        } else {
            resultMatrix = calculator.multiplyMatrices(firstMatrix, secondMatrix, new ElementInteger());
        }
    }

    /**
     * Method used to read values passed by user into matrices.
     *
     * @param request servlet request
     * @param matrix Matrix object
     * @param text String which equals 'first' or 'second' depending on matrix
     * @throws DimensionException object passed over from changeMatrixValue
     * method
     * @throws NumberFormatException object passed over from parseInt method
     */
    private void getMatrixValues(HttpServletRequest request, Matrix<Integer> matrix, String text) throws DimensionException, NumberFormatException {
        for (int i = 0; i < matrix.getHeight(); i++) {
            for (int j = 0; j < matrix.getWidth(); j++) {
                matrix.changeMatrixValue(i, j, Integer.parseInt(request.getParameter(text + "MatrixValue" + i + "_" + j)));
            }
        }
    }

//    /**
//     * Method used to provide data for HistoryServlet class - it stores
//     * information using a user session.
//     *
//     * @param request servlet request
//     * @param action String containing information about chosen operation
//     */
//    private void setSessionAttributes(HttpServletRequest request, String action) {
//        session = request.getSession();
//        if (session.getAttribute("counter") != null) {
//            counter = (int) session.getAttribute("counter");
//        }
//        session.setAttribute("firstMatrix" + counter, firstMatrix);
//        session.setAttribute("secondMatrix" + counter, secondMatrix);
//        session.setAttribute("resultMatrix" + counter, resultMatrix);
//        session.setAttribute("operation" + counter, action);
//        counter++;
//        session.setAttribute("counter", counter);
//    }
    
    /**
     * Method used to persist Calculation object (insert into a database).
     *
     * @param request servlet request
     * @param action string containing information about chosen operation
     * @throws PersistenceException exception thrown when persist operation did
     * not work
     */
    void writeToDatabase(HttpServletRequest request, String action) throws PersistenceException {
        session = request.getSession();
        dbManager = (DBManager) session.getAttribute("dbManager");
        Calculation calculation = new Calculation(firstMatrix, secondMatrix, resultMatrix, action);
        dbManager.persist(calculation);
    }

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
