package com.asseco.see.mk.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asseco.see.mk.model.Client;
import com.asseco.see.mk.model.Project;
import com.asseco.see.mk.model.Report;
import com.asseco.see.mk.model.Reservation;
import com.asseco.see.mk.model.Sector;
import com.asseco.see.mk.model.Seller;
import com.asseco.see.mk.model.Status;
import com.asseco.see.mk.service.IClientService;
import com.asseco.see.mk.service.IProjectService;
import com.asseco.see.mk.service.IReportService;
import com.asseco.see.mk.service.ISectorService;
import com.asseco.see.mk.service.ISellerService;
import com.asseco.see.mk.service.IStatusService;

@Controller
public class ReportController {
	@Autowired
	private IClientService clientService;

	@Autowired
	private IProjectService projectService;

	@Autowired
	private ISectorService sectorService;

	@Autowired
	private ISellerService sellerService;

	@Autowired
	private IStatusService statusService;

	@Autowired
	private IReportService reportService;

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String newReport(Model model) {

		model.addAttribute("reports", reportService.getReports());
		return "report";
	}

	@ModelAttribute("report")
	public Report report() {
		return new Report();
	}

	@RequestMapping(value = "/report", params = { "addRow" }, method = RequestMethod.POST)
	public String addReservation(final Report report, final BindingResult bindingResult) {
		report.getRecords().add(new Reservation());
		return "report";
	}

	@RequestMapping(value = "/report", params = { "saveReport" }, method = RequestMethod.POST)
	public String saveReservation(final Report report, final BindingResult bindingResult) {
		report.setDateModified(new Date());
		report.setName("report_" + new Date());
		reportService.saveReport(report);
		return "redirect:report";
	}

	@ModelAttribute("clients")
	public List<Client> clients() {
		return clientService.getClients();
	}

	@ModelAttribute("projects")
	public List<Project> projects() {
		return projectService.getProjects();
	}

	@ModelAttribute("sectors")
	public List<Sector> sectors() {
		return sectorService.getSectors();
	}

	@ModelAttribute("sellers")
	public List<Seller> sellers() {
		return sellerService.getSellers();
	}

	@ModelAttribute("statuses")
	public List<Status> statuses() {
		return statusService.getStatuses();
	}

}
