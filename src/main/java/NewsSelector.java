import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

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

	public static int PRETTY_PRINT_INDENT_FACTOR = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		int count = getPresentNum(context);
		JSONArray storage = initVar(request);
		response.getWriter().append(storage.getJSONObject(count++).toString(PRETTY_PRINT_INDENT_FACTOR));
		context.setAttribute("count", count);
	}

	private int getPresentNum(ServletContext context) {
		Object countObject = checkContextContent(context);
		int count = (Integer) context.getAttribute("count");
		return count;
	}

	private JSONArray initVar(HttpServletRequest request) throws IOException {
		String path = request.getSession().getServletContext().getRealPath("/") + "JSON\\json.txt";
		String xmlData = getdataReader(path);
		JSONObject jsonData = getxmltoJsonObject(xmlData);
		JSONArray storage = getNews(jsonData);
		return storage;
	}

	private Object checkContextContent(ServletContext context) {
		if (context.getAttribute("count") == null) {
			context.setAttribute("count", 0);
			return context.getAttribute("count");
		} else {
			return context.getAttribute("count");
		}

	}

	public static JSONArray getNews(JSONObject xmlJSONObj) throws IOException {
		String convertJSONtoStr = xmlJSONObj.toString();
		String pruning = convertJSONtoStr.substring(convertJSONtoStr.indexOf('['), convertJSONtoStr.indexOf(']') + 1);
		JSONArray newsStorage = new JSONArray(pruning);
		return newsStorage;
	}

	private static JSONObject getxmltoJsonObject(String xmlData) {
		JSONObject xmlJSONObj = XML.toJSONObject(xmlData);
		return xmlJSONObj;
	}

	private static String getdataReader(String path) throws IOException {
		File xmlFile = new File(path);
		String xmlData = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(xmlFile)));
		String line;
		while ((line = reader.readLine()) != null) {
			xmlData += line;
		}
		reader.close();
		return xmlData;
	}

}
