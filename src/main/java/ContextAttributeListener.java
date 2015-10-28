
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextAttributeListener implements ServletContextAttributeListener {

	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("The attribute name: " + event.getName() + " is added to ServletContext");

	}

	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("The attribute name:" + event.getName() + " is removed from ServletContext");
	}

	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("The attribute name: " + event.getName() + " is modified in ServletContext");
	}

}
