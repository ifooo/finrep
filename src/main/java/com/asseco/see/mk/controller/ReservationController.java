package com.asseco.see.mk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import com.asseco.see.mk.service.IReservationService;
import com.asseco.see.mk.service.ISectorService;
import com.asseco.see.mk.service.ISellerService;
import com.asseco.see.mk.service.IStatusService;

@Controller
// @RequestMapping(value = "/reservation")
@SessionAttributes("reservation")
public class ReservationController {

	@Autowired
	private IClientService iClientService;

	@Autowired
	private IProjectService iProjectService;

	@Autowired
	private ISectorService iSectorService;

	@Autowired
	private ISellerService iSellerService;

	@Autowired
	private IStatusService iStatusService;

	@Autowired
	private IReservationService iReservationService;

//	@RequestMapping(value = "/reservation")
//
//	public String newReservation(Model model) {
//		model.addAttribute("reservation", new Reservation());
//		model.addAttribute("clients", iClientService.getClients());
//		model.addAttribute("projects", iProjectService.getProjects());
//		model.addAttribute("sectors", iSectorService.getSectors());
//		model.addAttribute("sellers", iSellerService.getSellers());
//		model.addAttribute("statuses", iStatusService.getStatuses());
//		return "reservation";
//	}

	@ModelAttribute("reservation")
	public Reservation reservation() {
		return new Reservation();
	}
	
	@ModelAttribute("clients")
	public List<Client> clients(){
		return iClientService.getClients();
	}
	
	@ModelAttribute("projects")
	public List<Project> projects(){
		return iProjectService.getProjects();
	}
	@ModelAttribute("sectors")
	public List<Sector> sectors(){
		return iSectorService.getSectors();
	}
	@ModelAttribute("sellers")
	public List<Seller> sellers(){
		return iSellerService.getSellers();
	}
	@ModelAttribute("statuses")
	public List<Status> statuses(){
		return iStatusService.getStatuses();
	}
	
	

	@RequestMapping(value = "/process_res_form", method = RequestMethod.POST)
	public String processReservation(Reservation reservation, BindingResult result) {

		Sector sec = iSectorService.findSector(reservation.getSectorr().getId());
		reservation.setSectorr(sec);

		Client client = iClientService.findClient(reservation.getClient().getId());
		reservation.setClient(client);

		Project project = iProjectService.findProject(reservation.getProject().getId());
		reservation.setProject(project);

		Seller seller = iSellerService.findSeller(reservation.getSeller().getId());
		reservation.setSeller(seller);

		Status status = iStatusService.findStatus(reservation.getStatus().getId());
		reservation.setStatus(status);

		iReservationService.saveReservation(reservation);

		return "redirect:reservation";
	}

	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
	public String getReservations(Model model) {

		model.addAttribute("reservations", iReservationService.getReservations());
		return "reservation";
	}


}
