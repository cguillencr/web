package org.monarca.web;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.monarca.configuration.ManagerSession;
import org.monarca.configuration.SessionEntry;
import org.monarca.exceptions.NoRepoException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ExecuteController extends org.monarca.web.Controller{
	
	@RequestMapping (value = "/{project}/{branch}/{build}")
	public String workSpace(@PathVariable("project") String project, @PathVariable("branch") String branch, @PathVariable("build") String build, HttpServletRequest request, HttpServletResponse response, Model model) throws NoRepoException, IOException
	{
			
		workSpace = enviroment.getWorkSpace()+project+"/"+branch+"/"+build+"/";
		outputDirectory = workSpace+enviroment.getPrettyPrinter();
		repo = workSpace+enviroment.getRepoName()+".mrf";
			
		loadMain(project, branch, build);
						  
		return "redirect:/"+project+"/"+branch+"/"+build+"/index.html";
	}
	
	@RequestMapping (value = "/{project}/{branch}/{build}/execute")
	public void execute(
			@PathVariable(value="project") String project,
			@PathVariable(value="branch") String branch,
			@PathVariable(value="build") String build,			 
			@RequestParam(value="id", required=false) String id,
			@RequestParam(value="session", required=false) String session,
			@RequestParam(value="user", required=false) String user,
			@RequestParam(value="form", required=false) String form,
			@RequestParam(value="item", required=false) String item,
			@RequestParam(value="method", required=false) String method,
			@RequestParam(value="value", required=false) String value,
			@RequestParam(value="codeBlock", required=false) String codeBlock,
			HttpServletRequest request, HttpServletResponse response, Model model) throws NoRepoException, IOException
	{		
		CopyOnWriteArrayList<SessionEntry> list = ManagerSession.getSessionEntries();		
		boolean sessionExists=false;
		for(SessionEntry entry :  list) 
		{
			if(session != null && session.equalsIgnoreCase(entry.getSession()))
			{				
				sessionExists = true;
				break;
			}
		}
		if( ! sessionExists )
		{
			SessionEntry newSession = new SessionEntry();
			newSession.setId(id);
			newSession.setUserOracle(user);
			newSession.setSession(session);
			ManagerSession.addSessionEntry(newSession);
		}
		
		workSpace = enviroment.getWorkSpace()+project+"/"+branch+"/"+build+"/";
		outputDirectory = workSpace+enviroment.getPrettyPrinter();
		repo = workSpace+enviroment.getRepoName()+".mrf";	
		loadMain(project, branch, build);

		message.setForm(form);
		message.setEvent("execute");
		message.setBuild(build);
		message.setItem(item);
		message.setMethod(method);
		message.setUser(user);
		message.setValue(value);
		message.setCodeBlock(codeBlock);

		main.sendCommand(message);

			
	}
		
}
