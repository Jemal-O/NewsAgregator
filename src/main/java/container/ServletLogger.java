package container;

import org.springframework.stereotype.Component;

@Component
public class ServletLogger {

	public void traceConsole(String log) {
		System.out.println(log);
	}
}