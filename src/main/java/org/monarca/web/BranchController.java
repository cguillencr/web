package org.monarca.web;


import java.security.Principal;

import org.monarca.services.BranchManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BranchController {
	
	@Autowired
	private BranchManager branchManager;

	@RequestMapping(value="/{project}/", method=RequestMethod.GET)
	public String getView(@PathVariable ("project")String project, Model model, Principal principal ) {
		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("list",branchManager.getBranchByProjectDescription(project));
		model.addAttribute("project", project);
		
		return "branchesByProject";
	}	
}
