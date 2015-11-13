<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Folders with images</title>
</head>
<body>
	<h3>Previously added folders:</h3>
	<h1>${name}</h1>
	<h3>${nothing}</h3>
	<h3>
		<c:forEach var="item" items="${newsStorage}">
			<img src=${path } width="20px" height="20px"/>
			<c:out value="Folder path : " />
			<c:out value="${item}" />
			<br/>
		</c:forEach>
	</h3>
	<br/>
	<FORM action="/News/addition">
		<input type="text" name="folder" /> <input type="submit" value="Add path" />
	</FORM>
</body>
</html>