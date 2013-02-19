package org.monarca.web.topic.controllers;

import org.monarca.entities.User;
import org.monarca.services.ActivityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/Coverage")
public class CoverageController {
	public final static int ID_TOPIC = 2;
	
	@Autowired
	private ActivityManager activityManager;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getCoverageTab(Model model) {
		User u = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("activities",activityManager.getActivitiesByTopicAndUser(ID_TOPIC,u.getId()));
		return "topics/Coverage";
	}


}
