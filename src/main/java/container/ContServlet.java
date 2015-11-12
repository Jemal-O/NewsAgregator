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
public class ContServlet extends javax.servlet.http.HttpServlet {
	private ArrayList<String> storage = new ArrayList<String>();

	@RequestMapping(value = "/addition")
	public String doForwardToJsp(@RequestParam(value = "folder", required = false) String folder,
			HttpServletRequest request, HttpServletResponse response, Model model)
					throws ServletException, IOException {

		if ((folder == null) || (folder.equals(""))) {
			model.addAttribute("name", "Please enter the path");
		} else {
			storage.add(folder);
		}

		if (storage.isEmpty()) {
			model.addAttribute("nothing", "Nothing is added");
		} else {
			StringBuilder builder = new StringBuilder();
			String path = request.getSession().getServletContext().getRealPath("/") + "images\\folder.jpg";

			for (int i = 0; i < storage.size(); i++) {
				builder.append("<img src=" + path + " width='20px' height='20px'/> <b>Folder path : </b>");
				builder.append(storage.get(i));
				builder.append("<br>");
			}

			model.addAttribute("storage", builder);
		}

		return "folderAddition";

	}

}