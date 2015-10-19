
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

public class NewsSelector extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewsSelector() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getSession().getServletContext().getRealPath("/") + "JSON\\json.txt";

		JSONArray storage = getNews(path);
		String newsNumber = request.getParameter("newsNumber");
        if (newsNumber.equals("")) {
        	newsNumber =storage.toString();
        } else {
        	newsNumber =storage.getJSONObject(Integer.valueOf(newsNumber)).toString();
        }
        response.setContentType("text/plain");
        response.getWriter().write(newsNumber);
		
}
//		response.getWriter().append(storage.getJSONObject(0).toString());
//	}

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
