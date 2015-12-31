package com.asseco.see.mk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asseco.see.mk.model.Status;
import com.asseco.see.mk.service.IStatusService;

@Controller
public class StatusController {

	@Autowired
	private IStatusService statusService;

	@ModelAttribute
	public Status status() {
		return new Status();
	}

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public String getStatuses(Model model) {

		model.addAttribute("statuses", statusService.getStatuses());

		return "status";
	}

	@RequestMapping(value = "/status", method = RequestMethod.POST)
	public String saveStatus(Status status, BindingResult bindingResult) {
		statusService.saveStatus(status);
		return "redirect:status";
	}

}
