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
		<input type="submit" value="Receive news">
	</form>
	<form action="ContServlet" method="POST">
		<b> Write folder path:</b>
		<br>
		<input type="text" name="folder" /> 
		<input type="submit" value="Add path">
	</form>
</body>
</html>