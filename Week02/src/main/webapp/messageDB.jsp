<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Message</title>
</head>
<body>
<h2><%= request.getAttribute("Message") %></h2>
<a href="uploadDB.jsp">Back to Upload Page</a>
</body>
</html>