<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Login</title>
</head>
<body>
<h1><%= "Login Here!" %>
</h1>
<br/>

<form action="LoginServlet" method="post">
    <label for="usernameID">Enter Username: </label><input id="usernameID" type="text" name="uname"> <br>
    <label for="passwordID">Enter Password: </label><input id="passwordID" type="password" name="pwd"> <br>
    <input type="submit" value="submit"></inp>
</form>

</body>
</html>