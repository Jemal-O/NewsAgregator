package container;


import java.io.IOException;


import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;

@Component
public class XMLParser {

	public static JSONObject getxmltoJsonObject(String xmlData) {
		JSONObject xmlJSONObj = XML.toJSONObject(xmlData);
		return xmlJSONObj;
	}

	public static JSONArray getNewsStorage(JSONObject xmlJSONObj) throws IOException {
		String convertJSONtoStr = xmlJSONObj.toString();
		String pruning = convertJSONtoStr.substring(convertJSONtoStr.indexOf('['), convertJSONtoStr.indexOf(']') + 1);
		JSONArray newsStorage = new JSONArray(pruning);
		return newsStorage;
	}

}
