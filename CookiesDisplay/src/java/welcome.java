
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(urlPatterns = {"/welcome"})
public class welcome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            Cookie[] cookies = request.getCookies();
            out.println("Cookies Details:<br>");
            out.println("Name: " + cookies[0].getValue() + "<br>");
            out.println("Password: " + cookies[1].getValue() + "<br>");
        } catch (Exception e) {
            out.println("Error retrieving cookies.");
        }
        out.close();
    }

}
