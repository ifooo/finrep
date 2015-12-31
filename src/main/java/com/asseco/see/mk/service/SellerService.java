package com.asseco.see.mk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asseco.see.mk.model.Seller;
import com.asseco.see.mk.repository.SellerRepository;

@Service
@Transactional
public class SellerService implements ISellerService {
	@Autowired
	private SellerRepository sellerRepository;

	public List<Seller> getSellers() {
		return sellerRepository.findAll();
	}

	public Seller findSeller(Long id) {
		return sellerRepository.findOne(id);
	}

	public void saveSeller(Seller seller) {
		sellerRepository.save(seller);
	}

}
