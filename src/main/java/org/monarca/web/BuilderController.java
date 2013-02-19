package org.monarca.web;


import org.monarca.entities.Build;
import org.monarca.services.BuildManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class BuilderController {
	
	private Build build;
	
	@Autowired
	private BuildManager buildManager;
	
	
	@RequestMapping(value="/builder", method=RequestMethod.GET)
	public String getView(Model model) {
		build = new Build();
		
		model.addAttribute("build", build);
		
		return "build";
	}
	
	@RequestMapping(value="/{project}/builder", method=RequestMethod.GET)
	public String getViewByProject(Model model, @PathVariable("project") String project) {
		build = new Build();
		build.getBranch().getProject().setDescription(project);
		
		model.addAttribute("build", build);
		model.addAttribute("project", project);
		
		return "build";
	}
	
	@RequestMapping(value="/{project}/{branch}/builder", method=RequestMethod.GET)
	public String getViewbyBranch(Model model, @PathVariable("project") String project, @PathVariable("branch") String branch) {
		build = new Build();
		build.getBranch().getProject().setDescription(project);
		build.getBranch().setDescription(branch);
		
		model.addAttribute("build", build);
		model.addAttribute("project", project);
		model.addAttribute("branch", branch);
		
		return "build";
	}

	
	@RequestMapping(value="/{project}/{branch}/builder/insert", method=RequestMethod.GET)
	public String insert(@ModelAttribute ("build") Build build, @PathVariable("project") String project, @PathVariable("branch") String branch) throws Exception {
		
		buildManager.createBuild(build);
		
		return "redirect:/"+project+"/"+branch+"/";
	}
	
	@RequestMapping(value="/{project}/builder/insert", method=RequestMethod.GET)
	public String insertNoProject(@ModelAttribute ("build") Build build, @PathVariable("project") String project) throws Exception {
		
		buildManager.createBuild(build);
		
		return "redirect:/"+project+"/";
	}

	
}
