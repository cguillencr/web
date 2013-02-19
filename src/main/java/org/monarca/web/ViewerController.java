package org.monarca.web;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.monarca.exceptions.NoRepoException;
import org.monarca.services.TopicManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class ViewerController extends org.monarca.web.Controller{
	

	@Autowired
	private TopicManager topicManager;
	
	@RequestMapping (value = "/{project}/{branch}/{build}/{page}.html")
	public String viewer(@PathVariable("project") String project, @PathVariable("branch") String branch, @PathVariable("build") String build, @PathVariable("page") String page, HttpServletRequest request, HttpServletResponse response, Model model) throws NoRepoException, IOException
	{
		workSpace = enviroment.getWorkSpace()+project+"/"+branch+"/"+build+"/";
		outputDirectory = workSpace+enviroment.getPrettyPrinter();
		repo = workSpace+enviroment.getRepoName()+".mrf";

		loadMain(project, branch, build);
				
		if(!page.equalsIgnoreCase("index"))
		{
			  
			model.addAttribute("pageCode",project+"/"+branch+"/"+build+"/" + page+".html");
			model.addAttribute("topics",topicManager.getTopicsByUser(user.getId()));
			message.setEvent(page);
			main.sendCommand(message);
			return "viewer";
		}
		else
		{

			message.setEvent("index");
			main.sendCommand(message);
							
		} 
		
		readLargerTextFile(response, outputDirectory+page+".html");
		
		return null;
		
	}
	
	@RequestMapping (value = "/ajax/{project}/{branch}/{build}/{page}.html")
	public void ajaxViewer(@PathVariable("project") String project,  @PathVariable("branch") String branch, @PathVariable("build") String build, @PathVariable("page") String page, HttpServletRequest request, HttpServletResponse response, Model model) throws NoRepoException, IOException
	{
		workSpace = enviroment.getWorkSpace()+project+"/"+branch+"/"+build+"/";
		outputDirectory = workSpace+enviroment.getPrettyPrinter();
		
		readLargerTextFile(response, outputDirectory+page+".html");
	}
}
