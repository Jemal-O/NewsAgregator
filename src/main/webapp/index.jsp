<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>Epam News</title>
</head>
<body>
	<center>
		<h1>Hello! select the desired item</h1>
	</center>
	<form action="/News/news">
	 	If fields aren't filled, all news will be displayed
			<br>
			<br>
		<b>Enter the field description </b>
		<input type="text" name="fieldDesc"/>
			<br>
			<br> 
		<input type="submit" value="Receive news">
			<br>
		For Example fieldDesc - Viktoryia Barodzich
	</form>
	<form action="/News/addition">
		<b>Please, enter the folder name </b>
			<br>
		<input type="text" name="folder"/>
		<input type="submit" value="Add Folder">
	</form>
</body>
</html>