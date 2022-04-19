<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Signup</title>
</head>
<body>
<h1><%= "Signup Here!" %>
</h1>
<br/>

<form action="SignupServlet" method="post">
    <label for="usernameID">Enter Username: </label><input id="usernameID" type="text" name="uname"> <br>
    <label for="passwordID">Enter Password: </label><input id="passwordID" type="password" name="pwd"> <br>
    <input type="submit" value="submit"></input>
</form>

</body>
</html>