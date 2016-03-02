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

import com.asseco.see.mk.model.Seller;
import com.asseco.see.mk.service.ISellerService;

@Controller
public class SellerController {

	@Autowired
	private ISellerService sellerService;

	@ModelAttribute
	public Seller seller() {
		return new Seller();
	}

	@RequestMapping(value = "/seller", method = RequestMethod.GET)
	public String getSellers(Model model) {
		model.addAttribute("sellers", sellerService.getSellers());
		return "seller";
	}

	@RequestMapping(value = "/seller", method = RequestMethod.POST)
	public String saveSeller(Seller seller, BindingResult bindingResult) {
		sellerService.saveSeller(seller);
		return "redirect:seller";
	}

	@RequestMapping(value = "/seller", params = { "id" }, method = RequestMethod.GET)
	public @ResponseBody Seller getSeller(HttpServletRequest req) {
		final Long rowId = Long.valueOf(req.getParameter("id"));
		Seller editedSeller = sellerService.findSeller(rowId);
		return editedSeller;

	}

}
