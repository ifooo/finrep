package com.asseco.see.mk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asseco.see.mk.model.Sector;
import com.asseco.see.mk.repository.SectorRepository;

@Service
@Transactional
public class SectorService implements ISectorService {

	@Autowired
	private SectorRepository sectorRepository;

	public List<Sector> getSectors() {
		return sectorRepository.findAll();
	}

	public Sector findSector(Long id) {
		return sectorRepository.findOne(id);
	}

	public void saveSector(Sector sector) {
		sectorRepository.save(sector);
	}

}
