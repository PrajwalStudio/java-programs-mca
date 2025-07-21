<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Student Details</title>
</head>
<body>
    <jsp:useBean id="s" class="student.StudentBean" scope="session" />
    <jsp:setProperty name="s" property="usn" param="usn" />
    <jsp:setProperty name="s" property="name" param="name" />
    <jsp:setProperty name="s" property="percentage" param="percentage" />

    <h3>The student details are:</h3>
    <p>
        USN No: <jsp:getProperty name="s" property="usn" /><br>
        Name: <jsp:getProperty name="s" property="name" /><br>
        Percentage: <jsp:getProperty name="s" property="percentage" />
    </p>
</body>
</html>
