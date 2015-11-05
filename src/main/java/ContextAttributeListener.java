
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebListener
public class ContextAttributeListener implements ServletContextAttributeListener {
	ServletLogger sLogger;

	public ContextAttributeListener() {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		sLogger = (ServletLogger) ctx.getBean("servletLogger");
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
