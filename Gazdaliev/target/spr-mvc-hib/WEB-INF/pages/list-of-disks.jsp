<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of disks</title>
</head>
<body>
<h1> <sec:authentication property="principal.username" /> </h1>
<table border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="10%">Name</th><th width="15%">Description</th><th width="10%">Owner</th><th width="10%">Actions</th>
</tr>
</thead>
<tbody>
<sec:authentication var="user" property="principal.username" />
<h2>Here you can view all the free disks, and edit yours</h2>
<c:forEach var="disk" items="${disks}">

<tr>
	<td>${disk.name}</td>
	<td>${disk.description}</td>
	<td>${disk.owner}</td>

	<td>
    <c:if test="${disk.owner == user}">
	<a href="${pageContext.request.contextPath}/disk/edit/${disk.id}.html">Edit</a><br/>
	<a href="${pageContext.request.contextPath}/disk/delete/${disk.id}.html">Delete</a><br/>
    </c:if>
    <c:if test="${disk.owner != user}">
            <a href="${pageContext.request.contextPath}/takendisk/getdisk/${disk.id}.html">Borrow</a><br/>
    </c:if>
    </td>
</tr>
</c:forEach>
</tbody>
</table>
<p><a href="${pageContext.request.contextPath}/home">Home page</a></p>
<p><a href="logout">Logout</a></p>
</body>
</html>