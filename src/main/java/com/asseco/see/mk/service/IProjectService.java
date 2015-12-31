package com.asseco.see.mk.service;

import java.util.List;

import com.asseco.see.mk.model.Project;

public interface IProjectService {

	List<Project> getProjects();
	
	Project findProject(Long id);
	
	void saveProject(Project project);

}
