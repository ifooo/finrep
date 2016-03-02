package com.asseco.see.mk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asseco.see.mk.model.Report;
import com.asseco.see.mk.repository.ReportRepository;

@Service
@Transactional
public class ReportService implements IReportService {

	@Autowired
	private ReportRepository reportRepository;

	public void saveReport(Report report) {
		reportRepository.save(report);

	}

	public List<Report> getReports() {
		return reportRepository.findAll();
	}

	public Report findReport(Long id) {
		return reportRepository.findOne(id);
	}

}
