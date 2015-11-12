package container;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class NewsSelector {
	private HttpServletRequest request;
	private NewsKeeping newsKeeping;

	public NewsKeeping getNewsStorage() throws IOException {
		String xmlData = getXMLData(request);
		JSONObject jsonData = XMLParser.getxmltoJsonObject(xmlData);
		return newsKeeping.getNews(jsonData);
	}

	@RequestMapping(value = "/news")
	public String getAllNews(Model model) throws IOException {
		model.addAttribute("news", getNewsStorage());
		return "jsonTemplate";
	}

	@Autowired
	public void setHttpServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Autowired
	public void setNewsKeeping(NewsKeeping newsKeeping) {
		this.newsKeeping = newsKeeping;
	}

	private String getXMLData(HttpServletRequest request) throws IOException {
		String path = request.getSession().getServletContext().getRealPath("/") + "JSON\\json.txt";
		String xmlData = DataReader.getdataReader(path);
		return xmlData;
	}

}
