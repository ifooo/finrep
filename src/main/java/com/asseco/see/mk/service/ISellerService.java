package com.asseco.see.mk.service;

import java.util.List;

import com.asseco.see.mk.model.Seller;

public interface ISellerService {

	List<Seller> getSellers();

	Seller findSeller(Long id);
	
	void saveSeller(Seller seller);

}
