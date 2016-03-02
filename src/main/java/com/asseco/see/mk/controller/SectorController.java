package com.asseco.see.mk.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asseco.see.mk.model.Sector;
import com.asseco.see.mk.service.ISectorService;

@Controller
public class SectorController {

	@Autowired
	private ISectorService sectorService;

	@ModelAttribute("sector")
	public Sector sector() {
		return new Sector();
	}

	@RequestMapping(value = "/sector", method = RequestMethod.GET)
	public String getSectors(Model model) {

		model.addAttribute("sectors", sectorService.getSectors());

		return "sector";
	}

	@RequestMapping(value = "/sector", method = RequestMethod.POST)
	public String saveSector(Sector sector, BindingResult bindingResult) {

		sectorService.saveSector(sector);

		return "redirect:sector";
	}
	
	@RequestMapping(value = "/sector", params = { "id" }, method = RequestMethod.GET)
	public @ResponseBody Sector getSector(HttpServletRequest req) {
		final Long rowId = Long.valueOf(req.getParameter("id"));
		Sector editedSector = sectorService.findSector(rowId);
		return editedSector;

	}

}
