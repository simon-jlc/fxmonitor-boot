package com.simon.fxmonitor.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simon.fxmonitor.service.FxMonitorService;
import com.simon.fxmonitor.service.JobsStatistics;

/**
 * 
 * @since 28 août 2015
 * @author simon
 */
@RestController
@RequestMapping(value = "/api/stats")
public class StatisticsController {

	@Autowired
	FxMonitorService fxMonitorService;

	@RequestMapping(value = "categories/{projectId}", method = RequestMethod.GET)
	List<JobsStatistics> loadJobsStatis(
			@PathVariable("projectId") Long projectId) {
		return fxMonitorService.getStatisticsByCategory(projectId);
	}
}
