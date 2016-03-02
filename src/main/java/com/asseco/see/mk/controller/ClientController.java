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

import com.asseco.see.mk.model.Client;
import com.asseco.see.mk.service.IClientService;

@Controller
public class ClientController {
	@Autowired
	private IClientService clientService;

	@ModelAttribute("client")
	public Client client() {
		return new Client();
	}

	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public String getClients(Model model) {
		model.addAttribute("clients", clientService.getClients());
		return "client";
	}

	@RequestMapping(value = "/client", method = RequestMethod.POST)
	public String saveClient(Client client, BindingResult bindingResult) {
		clientService.saveClient(client);
		return "redirect:client";
	}

	@RequestMapping(value = "/client", params = { "id" }, method = RequestMethod.GET)
	public @ResponseBody Client getClient(HttpServletRequest req) {
		final Long rowId = Long.valueOf(req.getParameter("id"));
		Client editedClient = clientService.findClient(rowId);
		return editedClient;

	}

}
