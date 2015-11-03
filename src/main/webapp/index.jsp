<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>Epam News</title>
</meta>
</head>
<body>
	<center>
		<h1>Hello! select the desired item</h1>
	</center>
	<form action="NewsSelector">
	 If fields aren't filled, all news will be displayed
	<br>
	<br>
		<b>Write field name: </b> 
		
		<input type="text" name="fieldName" /> 
		<br>
		 For Example fieldName - author 
		<br> 
		<br>
		<b>Write Value:</b> 
		<input type="text" name="fieldDesc" /> 
		<input type="submit" value="Receive news">
		<br>
		For Example fieldDesc - Viktoryia Barodzich
		<br> 
		<br>
	</form>
	<form action="ContServlet" method="POST">
		<b> Write folder path:</b> <br> <input type="text" name="folder" />
		<input type="submit" value="Add path">
	</form>
</body>
</html>