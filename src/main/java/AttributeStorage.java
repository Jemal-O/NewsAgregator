import javax.servlet.ServletContext;

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
		Object countObject = checkContextContent(context);
		int count = (Integer) context.getAttribute("count");
		return count;
	}
}
