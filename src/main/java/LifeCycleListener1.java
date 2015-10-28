
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class LifeCycleListener1 implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("The servlet is ready to accept requests");
	}

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("Servlet removed");
	}

}
