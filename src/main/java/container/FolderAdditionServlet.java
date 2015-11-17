package container;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FolderAdditionServlet {
	private ArrayList<String> storage = new ArrayList<String>();

	@RequestMapping(value = "/addition")
	public ModelAndView addAndViewFolders(@RequestParam(value = "folder", required = false) String folder,
			HttpServletRequest request, ModelAndView modelAndView) throws ServletException, IOException {
		if ((!folder.isEmpty())) {
			storage.add(folder);
		} else {
			modelAndView.getModelMap().addAttribute("didNotEnter", "Please enter the path");
		}
		String path = request.getServletContext().getRealPath("/") + "images\\folder.jpg";
		modelAndView.getModelMap().addAttribute("path", path);
		modelAndView.getModelMap().addAttribute("newsStorage", storage);
		modelAndView.setViewName("folderAddition");
		return modelAndView;
	}
}