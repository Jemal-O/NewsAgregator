package container;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ModelSubstitution extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) {
		NewsKeeping news = (NewsKeeping) modelAndView.getModel().get("news");
		String fieldDesc = request.getParameter("fieldDesc");
		if (fieldDesc.isEmpty()) {
			modelAndView.getModelMap().addAttribute("news", news);
		} else {
			filterFields(modelAndView, news, fieldDesc);
		}
	}

	private void filterFields(ModelAndView modelAndView, NewsKeeping news, String fieldDesc) {
		NewsKeeping filter = new NewsKeeping();
		for (int i = 0; i < news.getListforKeeping().size(); i++) {
			String author =news.getListforKeeping().get(i).getAuthor();
			if (author.equals(fieldDesc)) {
				filter.getListforKeeping().add(news.getListforKeeping().get(i));
			}
		}
		modelAndView.getModelMap().addAttribute("news", filter);
	}
}