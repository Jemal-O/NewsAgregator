package container;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContServlet")
public class ContServlet extends javax.servlet.http.HttpServlet {
	static ArrayList<String> storage = new ArrayList<String>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext scontext = request.getServletContext();
		scontext.setAttribute("storage", storage);
		request.getRequestDispatcher("/folderAddition.jsp").forward(request, response);

	}
}