package org.monarca.web;


import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.monarca.configuration.ManagerSession;
import org.monarca.exceptions.NoRepoException;
import org.monarca.services.BuildManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BuildController {
	
	@Autowired
	private BuildManager buildManager;


	@RequestMapping(value="/{project}/{branch}/", method=RequestMethod.GET)
	public String getView(@PathVariable ("branch")String branch, 	
			Model model, Principal principal ) {	
		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("list",buildManager.getBuildByBranchDescription(branch));
		model.addAttribute("listSessions",ManagerSession.getSessionEntries());	
		model.addAttribute("branch", branch);
		
		return "buildsByBranch";
	}
	
	@RequestMapping (value = "/{project}/{branch}/bind")
	public String bind(@PathVariable("branch") String branch, 			 
			@RequestParam(value="session", required=false) String session,	
			HttpServletRequest request, HttpServletResponse response, Model model, Principal principal) 
					throws NoRepoException, IOException
	{		
		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("list",buildManager.getBuildByBranchDescription(branch));
		model.addAttribute("listSessions",ManagerSession.getSessionEntries());	
		String monarcaUser = principal.getName();		
		ManagerSession.bindSession(session, monarcaUser);
		
		return "buildsByBranch";
	}
	
	@RequestMapping (value = "/{project}/{branch}/unbind",method=RequestMethod.GET)
	public String unBind(@PathVariable("branch") String branch, 		 
			@RequestParam(value="session", required=false) String session,	
			HttpServletRequest request, HttpServletResponse response, Model model, Principal principal) 
					throws NoRepoException, IOException
	{					
		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("list",buildManager.getBuildByBranchDescription(branch));
		model.addAttribute("listSessions",ManagerSession.getSessionEntries());	
		String monarcaUser = principal.getName();		
		ManagerSession.unbindSession(session, monarcaUser);			
		
		return "buildsByBranch";
	}
	
	
}
