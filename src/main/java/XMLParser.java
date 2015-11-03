import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class XMLParser {


	static JSONObject getxmltoJsonObject(String xmlData) {
		JSONObject xmlJSONObj = XML.toJSONObject(xmlData);
		return xmlJSONObj;
	}

	static JSONArray getNews(JSONObject xmlJSONObj) throws IOException {
		String convertJSONtoStr = xmlJSONObj.toString();
		String pruning = convertJSONtoStr.substring(convertJSONtoStr.indexOf('['), convertJSONtoStr.indexOf(']') + 1);
		JSONArray newsStorage = new JSONArray(pruning);
		return newsStorage;
	}

}
