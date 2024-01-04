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
import pl.polsl.matrixcalculatorweb.model.DBManager;

/**
 * A class in the 'servlets' package. The class is the starting point of the
 * program and the main menu of it. It is a servlet class extending HttpServlet
 * class. It also controls the flow of the program. It displays four number
 * boxes each passing information about matrices' dimensions and two buttons -
 * one leading to a history of calculation (HistoryServlet) and second leading
 * to page displaying the matrices (MatrixTablesServlet).
 *
 * @author Maciej-Musiał
 * @version 1.1
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {
    
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
        
        session = request.getSession();
        dbManager = (DBManager) session.getAttribute("dbManager");
        if(dbManager == null) {
            dbManager = new DBManager();
            session.setAttribute("dbManager", dbManager);
        }
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <title>Matrix Calculator</title>\n"
                    + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <form action=\"HistoryServlet\">\n"
                    + "            <input type=\"submit\" name=\"button\" value=\"Historia\" style=\"float:left; margin:10px;\" />\n"
                    + "        </form>\n"
                    + "        <form action=\"MatrixTablesServlet\">\n"
                    + "            <input type=\"submit\" value=\"Dalej\" style=\"float:left; margin:10px;\" />\n"
                    + "            <p style=\"clear:both\">Program służący do wykonywania obliczeń dodawania, odejmowania oraz mnożenia macierzy.<br>"
                    +               "Elementy przechowywane w bazie danych to dwie tabele: obliczenia (\"Calculation\") "
                    +               "oraz macierze (\"Matrix\"), które są połączone trzema relacjami 1:1 z kluczami obcymi po stronie obliczeń.<br>"
                    +               "Tabela obliczeń składa się z klucza głównego, trzech kluczy obcych wiążących macierz z obliczeniem oraz rodzajem operacji - "
                    +               "tabela przechowuje poprzednio wykonane operacje.<br>"
                    +               "Tabela macierzy składa się z pól przechowujących wymiary macierzy, typ danych zawartych w macierzy oraz pola przechowującego jej elementy.<br>"
                    +               "Całość danych zawartych w tabelach pozwala wyświetlić historię obliczeń, do której można przejść poprzez naciśnięcie przycisku \"Historia\".<br>"
                    +               "Poprzez sesję przekazywane są dwa atrybuty: obiekt klasy \"DBManager\", "
                    +               "który umożliwia jednokrotne utworzenie fabryki menadżera encji (jednokrotne nawiązanie połączenia z bazą danych) "
                    +               "oraz informację o błędzie, który wystąpił w trakcie użytkowania problemu, aby móc go wyświetlić użytkownikowi.</p>"
                    + "            <h2 style=\"clear:both;\">Pierwsza macierz:</h2>\n"
                    + "                <p>Podaj ilość wierszy pierwszej macierzy:<input type=\"number\" name=valueFirstMatrixRow value=\"1\" min=\"1\" step=\"1\" style=\"width:40px;\"></p>\n"
                    + "                <p>Podaj ilość kolumn pierwszej macierzy:<input type=\"number\" name=valueFirstMatrixColumn value=\"1\" min=\"1\" step=\"1\" style=\"width:40px;\"></p>\n"
                    + "            <h2>Druga macierz:</h2>\n"
                    + "                <p>Podaj ilość wierszy drugiej macierzy:<input type=\"number\" name=valueSecondMatrixRow value=\"1\" min=\"1\" step=\"1\" style=\"width:40px;\"></p>\n"
                    + "                <p>Podaj ilość kolumn drugiej macierzy:<input type=\"number\" name=valueSecondMatrixColumn value=\"1\" min=\"1\" step=\"1\" style=\"width:40px;\"></p>\n"
                    + "        </form>\n"
                    + "    </body>\n"
                    + "</html>");
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

}
