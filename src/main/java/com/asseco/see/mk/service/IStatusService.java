package com.asseco.see.mk.service;

import java.util.List;

import com.asseco.see.mk.model.Status;

public interface IStatusService {

	List<Status> getStatuses();

	Status findStatus(Long id);
	
	void saveStatus(Status status);

}
