package com.asseco.see.mk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asseco.see.mk.model.Project;
import com.asseco.see.mk.repository.ProjectRepository;

@Service
@Transactional
public class ProjectService implements IProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Project> getProjects() {
		return projectRepository.findAll();
	}

	public Project findProject(Long id) {
		return projectRepository.findOne(id);
	}

	public void saveProject(Project project) {
		projectRepository.save(project);
	}

}
