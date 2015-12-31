package com.asseco.see.mk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asseco.see.mk.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
