package com.asseco.see.mk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asseco.see.mk.model.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {

}
