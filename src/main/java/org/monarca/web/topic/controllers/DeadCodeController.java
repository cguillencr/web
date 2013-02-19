package org.monarca.web.topic.controllers;

import javax.servlet.http.HttpServletRequest;

import org.monarca.entities.User;
import org.monarca.services.ActivityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/DeadCode")
public class DeadCodeController {
	public final static int ID_TOPIC = 1;
	
	@Autowired
	private ActivityManager activityManager;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getDeadCodeTab(Model model) {
		User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("activities",activityManager.getActivitiesByTopicAndUser(ID_TOPIC,u.getId()));
		return "topics/DeadCode";
	}
	
	@RequestMapping(value = "/getInstances", method = RequestMethod.GET)
	public @ResponseBody String getInstances(HttpServletRequest object) {
		int id = Integer.valueOf(object.getParameter("id"));
	return "//todo DEAD Code";
	}

}
