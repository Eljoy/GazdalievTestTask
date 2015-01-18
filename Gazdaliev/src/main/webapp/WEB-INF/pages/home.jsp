<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Home page</title>
</head>
<body>
<h1>Home page</h1>
<p>
<h1> <sec:authentication property="principal.username" /> </h1>
${message}<br/>
<a href="${pageContext.request.contextPath}/disk/add.html">Add new Disk</a><br/>
<a href="${pageContext.request.contextPath}/disk/list.html">List of free Disks</a><br/>
<a href="${pageContext.request.contextPath}/takendisk/takenbyuser.html">Disks borrowed by you</a><br/>
<a href="${pageContext.request.contextPath}/takendisk/takenbyotheruser.html">Disks borrowed by other users</a><br/>

</p>
<p><a href="logout">Logout</a></p>
</body>
</html>