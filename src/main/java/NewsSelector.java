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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebServlet("/NewsSelector")
public class NewsSelector extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		XMLParser xParser = (XMLParser) ctx.getBean("xmlParser");
		AttributeStorage attribStorage = (AttributeStorage) ctx.getBean("attributeStorage");
		DataReader dReader = (DataReader) ctx.getBean("dataReader");
		
		ServletContext context = request.getServletContext();
		int count = attribStorage.getPresentNum(context);
		
		String xmlData = getData(request, dReader);
		JSONArray storage = initVar(xmlData, xParser);
		
		response.getWriter().append(storage.toString());
		context.setAttribute("count", count);
	}
	
	

	private String getData(HttpServletRequest request, DataReader dReader) throws IOException {
		String path = request.getSession().getServletContext().getRealPath("/") + "JSON\\json.txt";
		String xmlData = dReader.getdataReader(path);
		return xmlData;
	}

	private JSONArray initVar(String xmlData, XMLParser xParser) throws IOException {
		JSONObject jsonData = xParser.getxmltoJsonObject(xmlData);
		JSONArray storage = xParser.getNews(jsonData);
		return storage;
	}

}
