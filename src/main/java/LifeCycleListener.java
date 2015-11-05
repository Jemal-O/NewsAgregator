
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebListener
public class LifeCycleListener implements ServletRequestAttributeListener, ServletRequestListener {
	ServletLogger sLogger;

	public LifeCycleListener() {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		sLogger = (ServletLogger) ctx.getBean("servletLogger");
	}

	public void requestDestroyed(ServletRequestEvent sre) {
		sLogger.traceConsole("The request " + sre.getServletRequest() + " has been sent");
	}

	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		sLogger.traceConsole("The attribute name: " + srae.getName() + " is removed from request" + srae.getServletRequest());
	}

	public void requestInitialized(ServletRequestEvent sre) {
		sLogger.traceConsole("The request " + sre.getServletRequest() + " from Server "
				+ sre.getServletContext().getServerInfo() + " has been sent");

	}

	public void attributeAdded(ServletRequestAttributeEvent srae) {
		sLogger.traceConsole("The attribute name: " + srae.getName() + " is added to request" + srae.getServletRequest());
	}

	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		sLogger.traceConsole("The attribute name: " + srae.getName() + " is modified in request" + srae.getServletRequest());
	}

}
