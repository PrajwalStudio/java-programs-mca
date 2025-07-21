
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            response.setContentType("text/html");
            PrintWriter pwriter = response.getWriter();
            String name = request.getParameter("username");
            String password = request.getParameter("password");
            pwriter.print("Hello, " + name);
            pwriter.print("<br>Your password is:" + password);
            Cookie c1 = new Cookie("name", name);
            Cookie c2 = new Cookie("password", password);
            response.addCookie(c1);
            response.addCookie(c2);
            pwriter.print("<br><a href='welcome'>View Details</a>");
            pwriter.close();
        } catch (Exception exp) {
            System.out.println(exp);
        }

    }

}
