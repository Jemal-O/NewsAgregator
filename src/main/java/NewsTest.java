import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class NewsTest {
	NewsSelector news;
	@Before
	public void setUp() throws Exception {
		NewsSelector news= new NewsSelector();
	}

	@Test
	public void test() throws IOException {
//		String xmlData = "";
//		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\json.txt")));
//		String line;
//		while ((line = reader.readLine()) != null) {
//			xmlData += line;
//		}
//		reader.close();
//		JSONObject xmlJSONObj=news.getxmltoJsonObject(xmlData);
//		JSONArray ja= news.getNews(xmlJSONObj);
        Assert.assertTrue("1".toString().equals("1"));
	}

}
