package container;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import org.springframework.beans.factory.annotation.Autowired;

public class ContextAttributeListener implements ServletContextAttributeListener {
	ServletLogger sLogger;

	@Autowired
	public ContextAttributeListener() {
		sLogger = new ServletLogger();
	}

	public void attributeAdded(ServletContextAttributeEvent event) {
		sLogger.traceConsole("The attribute name: " + event.getName() + " is added to ServletContext");

	}

	public void attributeRemoved(ServletContextAttributeEvent event) {
		sLogger.traceConsole("The attribute name:" + event.getName() + " is removed from ServletContext");
	}

	public void attributeReplaced(ServletContextAttributeEvent event) {
		sLogger.traceConsole("The attribute name: " + event.getName() + " is modified in ServletContext");
	}

}
