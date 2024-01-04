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
 * HttpServlet class. It also controls the flow of the program. It displays the
 * error message and one button leading to main page (MainServlet).
 *
 * @author Maciej-Musiał
 * @version 1.1
 */
@WebServlet(name = "ErrorServlet", urlPatterns = {"/ErrorServlet"})
public class ErrorServlet extends HttpServlet {

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
        session = request.getSession();
        String errorType = (String) session.getAttribute("errorType");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Matrix Calculator</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"MainServlet\">");
            out.println("<input type=\"submit\" value=\"Powrót\" style=\"margin:10px;\" />");
            out.println("</form>");
            out.println("<h1>Błąd!</h1>");
            out.println("<h2>" + errorType + "</h2>");
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

}
