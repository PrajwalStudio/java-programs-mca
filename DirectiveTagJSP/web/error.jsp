<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
    <h2>An error occurred!</h2>
    <p>Error: <%= exception.getMessage() %></p>
    <a href="index.html">Go Back</a>
</body>
</html>
