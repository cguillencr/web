package org.monarca.web;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.monarca.services.BuildManager;
import org.monarca.services.ProjectManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {
	@Autowired
	private ProjectManager projectManager;
	
	@Autowired
	private BuildManager buildManager;
	
	@RequestMapping (value = "/")
	public String list(HttpServletRequest request, HttpServletResponse response, Model model, Principal principal )
	            throws ServletException, IOException {		

		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("list",projectManager.getProjects());	
		return "projects";
	}

}
