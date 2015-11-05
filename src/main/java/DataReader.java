import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataReader {
	
	static String getdataReader(String path) throws IOException {
		
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
