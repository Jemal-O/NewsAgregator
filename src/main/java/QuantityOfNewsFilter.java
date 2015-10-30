import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

@WebFilter(urlPatterns = { "/QuantityOfNewsFilter", "/NewsSelector" })
public class QuantityOfNewsFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		ArrayList<String> list = new ArrayList<String>();
		ResponseInterceptor iResponse = new ResponseInterceptor((HttpServletResponse) response);
		String fieldName = request.getParameter("fieldName");
		String fieldDesc = request.getParameter("fieldDesc");

		chain.doFilter(request, iResponse);

		ServletContext context = request.getServletContext();
		int count = getPresentNum(context);
		PrintWriter appender = response.getWriter();
		JSONArray obtainData = new JSONArray(iResponse.toString());
		
		if ((fieldName.equals("") && fieldDesc.equals("")) || (fieldName.equals("") && fieldDesc.equals(""))
				|| ((fieldName == null) && (fieldDesc.equals("")))) {
			
			appender.println(obtainData.getJSONObject(count++).toString());
			
		} else {
			filterFields(obtainData, list, fieldName, fieldDesc);
			appender.println(list.get(count++));
		}
		context.setAttribute("count", count);
	}

	private static void filterFields(JSONArray array, ArrayList list, String field, String value) {
		for (int i = 0; i < array.length(); i++) {
			// For Example Viktoryia Barodzich
			if (array.getJSONObject(i).get(field).equals(value)) {
				list.add(array.getJSONObject(i).toString());
			}
		}
	}

	private int getPresentNum(ServletContext context) {
		Object countObject = checkContextContent(context);
		int count = (Integer) context.getAttribute("count");
		return count;
	}

	private Object checkContextContent(ServletContext context) {
		Object paramCount = context.getAttribute("count");
		if (paramCount == null) {
			context.setAttribute("count", 0);
			return paramCount;
		} else {
			return paramCount;
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}
}