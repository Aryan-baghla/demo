<%--
  Created by IntelliJ IDEA.
  User: manni
  Date: 28/07/22
  Time: 1:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList"%>


<html>
<head>
    <meta charset="x-iso-8859-1">
    <title>HOMEPAGE</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/FileController">Home Folder</a>
 <%
    String path = (String) request.getAttribute("path");
     ArrayList<String> folders = (ArrayList<String>) request.getAttribute("folders");
     ArrayList<String> files = (ArrayList<String>) request.getAttribute("files");

 %>

<h1>List of folders</h1>
<h2> Current folder - <%= path %></h2>
<c:forEach items="${folders}" var = "folder">
<form action="<%=request.getContextPath()%>/FileController" method="get">
     <input type="hidden" name="path" value=" ${path}/${folder}"/>
     <input type="submit" value="${folder}"/>
</form>


</c:forEach>

</html>
