

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NewsSelector extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NewsSelector() {
        super();
    }
    
//    String xml = "<user>" +
//
//                        "<name>Pavel</name>" +
//
//                        "<sername>Samolisov</sername>" +
//
//                        "<age>23</age>" +
//
//                        "<rating>89.93</rating>" +
//
//                     "</user>";



    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		URL url = new URL("http://androiddocs.ru/api/friends.json");
        StringBuilder sb = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
        	response.getWriter().append(inputLine);
        }
        in.close();

	}

}
