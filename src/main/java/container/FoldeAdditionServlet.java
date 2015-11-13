package container;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoldeAdditionServlet {
	private ArrayList<String> storage = new ArrayList<String>();

	@RequestMapping(value = "/addition")
	public String addAndViewFolders(@RequestParam(value = "folder", required = false) String folder,
			HttpServletRequest request, HttpServletResponse response, Model model)
					throws ServletException, IOException {
		if ((folder == null) || ("".equals(folder))) {
			model.addAttribute("name", "Please enter the path");
		} else {
			storage.add(folder);
		}
		if (storage.isEmpty()) {
			model.addAttribute("nothing", "Nothing is added");
		} else {
			String path = request.getServletContext().getRealPath("/") + "images\\folder.jpg";
			model.addAttribute("path", path);
			model.addAttribute("newsStorage", storage);
		}
		return "folderAddition";
	}
}