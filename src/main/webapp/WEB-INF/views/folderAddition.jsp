<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>Folders with images</title>
</head>
<body>
	<h3>Previously added folders:</h3>
	<%
		ArrayList list = (ArrayList) request.getServletContext().getAttribute("storage");
		if ((request.getParameter("folder").equals("null")) || (request.getParameter("folder").equals(""))) {
	%>
	<h1>Please enter the path</h1>
	<%
		} else {
			list.add(request.getParameter("folder"));

		}
		if (list.isEmpty()) {
	%>
	<h5>nothing is added</h5>
	<%
		} else {
			for (int i = 0; i < list.size(); i++) {
	%>
	<div id=<%=i%>>
		<img
			src=<%=request.getSession().getServletContext().getRealPath("/") + "images\\folder.jpg"%>
			width="20px" height="20px"> <b>Folder path:</b>
		<%=list.get(i)%>
	</div>
	<%
		}
		}
	%>
	<br>
	<FORM action="folderAddition.jsp" method="POST">

		<input type="text" name="folder" /> <input type="submit"
			value="Add path" />

	</FORM>

</body>
</html>