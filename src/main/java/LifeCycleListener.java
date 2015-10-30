
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class LifeCycleListener implements ServletRequestAttributeListener, ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("The request " + sre.getServletRequest() + " has been sent");
	}

	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println(
				"The attribute name: " + srae.getName() + " is removed from request" + srae.getServletRequest());
	}

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("The request " + sre.getServletRequest() + " from Server "
				+ sre.getServletContext().getServerInfo() + " has been sent");

	}

	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("The attribute name: " + srae.getName() + " is added to request" + srae.getServletRequest());
	}

	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println(
				"The attribute name: " + srae.getName() + " is modified in request" + srae.getServletRequest());
	}

}
