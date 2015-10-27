
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class LifeCycleListener1 implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("The servlet is ready to accept requests");
	}

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("Servlet removed");
	}

}
