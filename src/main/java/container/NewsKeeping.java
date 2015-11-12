package container;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class NewsKeeping {
	private List<NewsObject> newsObj = new ArrayList<NewsObject>();

	public List<NewsObject> getListforKeeping() {
		return newsObj;
	}

	public void setNews(List<NewsObject> newsObj) {
		this.newsObj = newsObj;
	}

	public NewsKeeping getNews(JSONObject xmlJSONObj) throws IOException {
		JSONArray ja = XMLParser.getNewsStorage(xmlJSONObj);
		NewsKeeping news = new NewsKeeping();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ja.length(); i++) {
			NewsObject newsObj = new NewsObject();
			newsObj.setAuthor(ja.getJSONObject(i).get("author").toString());
			newsObj.setLink(ja.getJSONObject(i).get("link").toString());
			newsObj.setGuid(ja.getJSONObject(i).get("guid").toString());
			newsObj.setDescription(ja.getJSONObject(i).get("description").toString());
			newsObj.setTitle(ja.getJSONObject(i).get("title").toString());
			newsObj.setPubDate(ja.getJSONObject(i).get("pubDate").toString());

			news.getListforKeeping().add(newsObj);
		}
		return news;
	}
}
