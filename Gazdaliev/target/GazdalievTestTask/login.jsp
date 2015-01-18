<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Login</title>
</head>
<body>
<h1>Login:</h1>


<form method="POST"  action="/login">
    <table>
        <tbody>
        <tr>
            <td>Username:</td>
            <td> <input type="text" id="username" name="username" /></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input  type="password"  id = "password" name="password" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Sign in" /></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</form>
<p style="color: red">
    <c:if test="${param.error == 'invalidLoginPassword'}">
        Invalid login or password.
    </c:if>
</p>

</body>
</html>