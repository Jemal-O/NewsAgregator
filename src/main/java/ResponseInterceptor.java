import java.io.CharArrayWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ResponseInterceptor extends HttpServletResponseWrapper {
	private CharArrayWriter buffer;

	public ResponseInterceptor(HttpServletResponse response) {
		super(response);
		buffer = new CharArrayWriter();
	}

	public PrintWriter getWriter() {
		return new PrintWriter(buffer);
	}

	public String toString() {
		return buffer.toString();
	}

}
