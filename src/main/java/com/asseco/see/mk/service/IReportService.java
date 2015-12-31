package com.asseco.see.mk.service;

import java.util.List;

import com.asseco.see.mk.model.Report;

public interface IReportService {

	void saveReport(Report report);
	
	List<Report> getReports();

}
