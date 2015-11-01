package com.simon.fxmonitor.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simon.fxmonitor.service.FxMonitorService;
import com.simon.fxmonitor.service.JobsStatistics;

/**
 * 
 * @since 26 août 2015
 * @author simon
 */
@Controller
public class ApplicationController {

	@Autowired FxMonitorService fxMonitorService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	String loginForm(Model model) {
		// TODO 
		model.addAttribute("title", "Login");
		return "login";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	String login() {
		// TODO control authentication using spring security
		return "redirect:/";
	}
	
	@RequestMapping("/")
	String index(Model model) {
		List<JobsStatistics> jobsStatisticsByProject = fxMonitorService.getStatisticsByProject();
		model.addAttribute("jobsStatistics", jobsStatisticsByProject);
		model.addAttribute("title", "Dashboard");
		return "index";
	}
	
	@RequestMapping("/jobs")
	String jobs(Model model) {
		model.addAttribute("title", "Jobs");
		return "jobs";
	}
	
	@RequestMapping("/transcodifications")
	String transcodifications(Model model) {
		model.addAttribute("title", "Transcodifications");
		model.addAttribute("warningMessages", "TODO: transcodifications");
		return "transcodifications";
	}
	
    public List<?> getCategories(String searchItem) {
    	return null;
    }
}