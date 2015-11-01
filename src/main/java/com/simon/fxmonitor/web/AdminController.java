package com.simon.fxmonitor.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @since 28 août 2015
 * @author simon 
 */
@Controller
public class AdminController {

	@RequestMapping("/admin/teams")
	String teams(Model model) {
		model.addAttribute("title", "Teams");
		model.addAttribute("warningMessages", "TODO: admin/teams");
		return "teams";
	}
	
	@RequestMapping("/admin/processes")
	String processes(Model model) {
		model.addAttribute("title", "Processes");
		model.addAttribute("warningMessages", "TODO: admin/processes");
		return "processes";
	}
}
