package container;

import org.springframework.stereotype.Component;

@Component
public class ServletLogger {

	public void traceConsole(String arg0) {
		System.out.println(arg0);
	}

}
