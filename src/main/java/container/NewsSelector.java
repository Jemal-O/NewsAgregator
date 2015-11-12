package container;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewsSelector {
	private HttpServletRequest request;
	private NewsKeeping newsKeeping;
	private XMLParser xmlParser;

	public NewsKeeping getNewsStorage() throws IOException {
		String xmlData = getXMLData(request);
		JSONObject jsonData = xmlParser.getxmltoJsonObject(xmlData);
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

	@Autowired
	public void setXMLParser(XMLParser xmlParser) {
		this.xmlParser = xmlParser;
	}

	private String getXMLData(HttpServletRequest request) throws IOException {
		String path = request.getSession().getServletContext().getRealPath("/") + "JSON\\json.txt";
		String xmlData = DataReader.getdataReader(path);
		return xmlData;
	}

}
