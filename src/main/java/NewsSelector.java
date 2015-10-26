
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class NewsSelector extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getSession().getServletContext().getRealPath("/") + "JSON\\json.txt";

		JSONArray storage = getNews(path);
		response.getWriter().append(storage.getJSONObject(0).toString());
	}

	public static JSONArray getNews(String path) throws IOException {
		File json = new File(path);
		String jsonData = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(json)));
		String line;
		while ((line = reader.readLine()) != null) {
			jsonData += line + "\n";
		}
		reader.close();
		JSONArray array = new JSONArray(jsonData);
		return array;
	}

}
