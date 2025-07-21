
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/displayUser")
public class displayUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            out.println("<html><body>");
            out.println("<h2>Welcome, " + username + "</h2>");
            out.println("<p><b>Your Password is:</b> " + password + "</p>");
            out.println("</body></html>");
        }
    }
}
