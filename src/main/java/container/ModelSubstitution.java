package container;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ModelSubstitution extends HandlerInterceptorAdapter {
	private AttributeStorage attrStorage;

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) {
		NewsKeeping news = (NewsKeeping) modelAndView.getModel().get("news");
		String fieldDesc = request.getParameter("fieldDesc");

		if (fieldDesc.equals("") || fieldDesc == null) {

			modelAndView.getModelMap().addAttribute("news", news);

		} else {
			filterFields(modelAndView, news, fieldDesc);
		}
	}

	@Autowired
	public void setAttrStrorageBean(AttributeStorage attrStorage) {
		this.attrStorage = attrStorage;
	}

	private void filterFields(ModelAndView modelAndView, NewsKeeping news, String fieldDesc) {
		NewsKeeping filter = new NewsKeeping();
		for (int i = 0; i < news.getListforKeeping().size(); i++) {

			if (news.getListforKeeping().get(i).getAuthor().equals(fieldDesc)) {
				filter.getListforKeeping().add(news.getListforKeeping().get(i));
			}
		}
		modelAndView.getModelMap().addAttribute("news", filter);
	}
}
