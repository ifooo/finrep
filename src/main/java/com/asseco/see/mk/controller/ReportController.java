package com.asseco.see.mk.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

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
@SessionAttributes
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
	public String reports(Model model) {

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
		return "edit";
	}

	@RequestMapping(value = "/report", params = { "removeRow" }, method = RequestMethod.POST)
	public String removeReservation(final Report report, final BindingResult bindingResult,
			final HttpServletRequest req) {
		final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
		report.getRecords().remove(rowId.intValue());
		return "edit";
	}

	@RequestMapping(value = "/report", params = { "saveReport" }, method = RequestMethod.POST)
	public String saveReservation(final @Valid Report report, final BindingResult bindingResult, Errors errors) {

		if (errors.hasFieldErrors()) {
			return "report";
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username

		report.setDateModified(new Date());
		report.setName("report_" + new Date());
		report.setModifiedBy(name);
		reportService.saveReport(report);
		return "redirect:report";
	}

	@RequestMapping(value = "/report/{id}/edit", method = RequestMethod.GET)
	public String editReservations(@PathVariable Long id, Report report, Model model) {
		Report editReport = reportService.findReport(id);
		List<Reservation> reservations = editReport.getRecords();
		List<Reservation> activeReservations = new ArrayList<>();

		for (Reservation activeReservation : reservations) {
			if (!activeReservation.getStatus().getStatus().equals("Zatvoreno")) {
				activeReservations.add(activeReservation);
			}
		}
		editReport.setRecords(activeReservations);
		model.addAttribute("report", editReport);
		return "edit";
	}

	@RequestMapping(value = "/report/edit", method = RequestMethod.GET)
	public String newReservations(Model model) {
		return "edit";
	}

	@RequestMapping(value = "/report/{id}/view", method = RequestMethod.GET)
	public String viewReport(@PathVariable Long id, Report report, Model model) {
		Report editReport = reportService.findReport(id);
		List<Reservation> reservations = editReport.getRecords();
		model.addAttribute("report", editReport);
		model.addAttribute("records", reservations);
		return "view";
	}

	@RequestMapping(value = "/report", params = { "cancel" }, method = RequestMethod.POST)
	public String cancel() {
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
