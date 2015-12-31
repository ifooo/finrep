package com.asseco.see.mk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asseco.see.mk.model.Status;
import com.asseco.see.mk.repository.StatusRepository;

@Service
@Transactional
public class StatusService implements IStatusService {
	@Autowired
	private StatusRepository statusRepository;

	public List<Status> getStatuses() {
		return statusRepository.findAll();
	}

	public Status findStatus(Long id) {
		return statusRepository.findOne(id);
	}

	public void saveStatus(Status status) {
		statusRepository.save(status);
	}

}
