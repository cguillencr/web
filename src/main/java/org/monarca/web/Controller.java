package org.monarca.web;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.servlet.http.HttpServletResponse;

import monarca.listener.MonarcaMsg;

import org.monarca.configuration.Enviroment;
import org.monarca.configuration.ManagersFactory;
import org.monarca.entities.User;
import org.monarca.exceptions.NoRepoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import converter._Main;

@org.springframework.stereotype.Controller
public abstract class Controller {
	
	protected Enviroment enviroment;
	protected String page =null;
	protected String repo =null;
	protected _Main main=null;
	protected String workSpace= null;
	protected String outputDirectory= null;
	protected User user;
	protected MonarcaMsg message;
	
	@Autowired
	public void setEnviroment(Enviroment enviroment)
	{
		this.enviroment =enviroment;
	}
		
	@InitBinder
	public void initBinder (WebDataBinder binder)
	{
		user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		message = new MonarcaMsg();
		message.setUser(user.getUsername());
	}
	
	protected void loadMain(String project, String branch, String build) throws NoRepoException
	{
		boolean managerAlreadyExists = 	ManagersFactory.existsBuildForProject(project, branch, build);
	
		if(!managerAlreadyExists)
		{

			ManagersFactory.addManager(project, branch, build, repo, workSpace, enviroment.getQueueUrl());
			main = ManagersFactory.getMonarcaInstance(project, branch, build);
			main.setWorkSpace(outputDirectory);
			main.execute();	

		}
		else
		{
			main = ManagersFactory.getMonarcaInstance(project, branch, build);	
		}

	}
	

	
	protected void readLargerTextFile(HttpServletResponse response, String aFileName) throws IOException {

		 response.setContentType("text/html;charset=UTF-8");
		 response.setCharacterEncoding("UTF-8");

	 
	    Path path = Paths.get(aFileName);
    	Scanner scanner =  new Scanner(path,"UTF-8");
    	while (scanner.hasNextLine()){
    		response.getWriter().println(scanner.nextLine());
	    }      

	 }
}
