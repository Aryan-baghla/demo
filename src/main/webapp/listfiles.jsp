
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
</br>
</c:forEach>



<h1>=========================</h1>
    <h1>List of files</h1>
    <c:forEach items="${files}" var="file">
        <c:url value="/DownloadController" var="downloadurl">
            <c:param name="path" value="${path}"></c:param>
            <c:param name="file" value="${file}"></c:param>

        </c:url>
    <a href="${downloadurl}">${file}</a>
    </c:forEach>
</br>
</br>
<c:url value="/UploadController" var="uploadurl">
    <c:param name="path" value="${path}"></c: param>
</c:url>
<form action="${uploadurl}" method="post" enctype="multipart/form-data">
    Select files :: <input type="file" name="files" multiple />
    <input type="submit" value="Upload Files" />
</form>
</body>
</html>
