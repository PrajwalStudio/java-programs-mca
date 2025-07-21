<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="java.util.*"
         errorPage="error.jsp"
         session="true"
         buffer="8kb"
         autoFlush="true"
         isELIgnored="false" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Result Page</title>
    </head>
    <body>
        <h2>Date: <%= new Date() %></h2>

        <%
            int x = Integer.parseInt(request.getParameter("number"));
            if (x > 0) {
                out.println("<p>" + x + " is a positive number</p>");
            } else if (x < 0) {
                out.println("<p>" + x + " is a negative number</p>");
            } else {
                out.println("<p>Number is zero</p>");
            }
        %>
    </body>
</html>
