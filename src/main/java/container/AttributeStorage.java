package container;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

@Component
public class AttributeStorage {

	Object checkContextContent(ServletContext context) {
		if (context.getAttribute("count") == null) {
			context.setAttribute("count", 0);
			return context.getAttribute("count");
		} else {
			return context.getAttribute("count");
		}
	}

	int getPresentNum(ServletContext context) {
		int count = (Integer) context.getAttribute("count");
		return count;
	}
}
