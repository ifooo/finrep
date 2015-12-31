package com.asseco.see.mk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asseco.see.mk.model.Project;
import com.asseco.see.mk.service.IProjectService;

@Controller
public class ProjectController {

	@Autowired
	private IProjectService projectService;

	@ModelAttribute("project")
	public Project project() {
		return new Project();
	}

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String getProjects(Model model) {
		model.addAttribute("projects", projectService.getProjects());
		return "project";
	}
	
	@RequestMapping(value="/project", method=RequestMethod.POST)
	public String saveProject(Project project, BindingResult bindingResult){
		projectService.saveProject(project);
		return "redirect:project";
		
	}

}
