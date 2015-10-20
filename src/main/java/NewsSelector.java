import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class NewsSelector extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int i;
	public static int PRETTY_PRINT_INDENT_FACTOR = 1;

	public NewsSelector() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getSession().getServletContext().getRealPath("/") + "JSON\\json.txt";

		JSONArray storage = getNews(path);
		ServletContext sc = this.getServletContext();
		sc.setAttribute("count", 0);
		int n = (Integer) sc.getAttribute("count");
		response.setContentType("text/html");
		response.getWriter().append(storage.getJSONObject(i++).toString(PRETTY_PRINT_INDENT_FACTOR));
	}

	public static JSONArray getNews(String path) throws IOException {
		File xmlFile = new File(path);
		String xmlData = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(xmlFile)));
		String line;
		while ((line = reader.readLine()) != null) {
			xmlData += line;
		}
		reader.close();

		JSONObject xmlJSONObj = XML.toJSONObject(xmlData);
		String convertJSONtoStr = xmlJSONObj.toString();
		String pruning = convertJSONtoStr.substring(convertJSONtoStr.indexOf('['), convertJSONtoStr.indexOf(']') + 1);
		JSONArray newsStorage = new JSONArray(pruning);
		return newsStorage;
	}

}
