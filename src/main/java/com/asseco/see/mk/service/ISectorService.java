package com.asseco.see.mk.service;

import java.util.List;

import com.asseco.see.mk.model.Sector;

public interface ISectorService {

	List<Sector> getSectors();
	
	Sector findSector(Long id);
	
	void saveSector(Sector sector);

}
