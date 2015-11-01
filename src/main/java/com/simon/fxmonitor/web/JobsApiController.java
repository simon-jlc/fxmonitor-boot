package com.simon.fxmonitor.web;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.simon.fxmonitor.service.FxMonitorService;
import com.simon.fxmonitor.service.dto.JobDTO;
import com.simon.fxmonitor.service.dto.JobLightDTO;
import com.simon.fxmonitor.web.ui.BootstrapAlert;
import com.simon.fxmonitor.web.ui.BootstrapAlert.BootstrapAlertType;

/**
 * 
 * @since 28 août 2015
 * @author simon 
 */
@RestController
@RequestMapping(value="/api/jobs")
@Slf4j
public class JobsApiController {

	@Autowired FxMonitorService fxMonitorService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<JobLightDTO> getLastJobs() {
    	log.info("Loading jobs...");
    	List<JobLightDTO> jobs = fxMonitorService.findAllJobs();
        return jobs;
    }
    
	@RequestMapping(value="{id}", method=RequestMethod.GET)
    public JobDTO getJobDetails(@PathVariable("id") Long id) {
		JobDTO job = fxMonitorService.findJobDetailsById(id);
		return job;
    }
	
	@RequestMapping(value="categories/{name}", method=RequestMethod.GET)
    public List<String> findCategoriesByName(@PathVariable("name") String name) {
		return fxMonitorService.findCategoriesByNameLike(name).stream().map(c -> c.getName()).collect(Collectors.toList());
    }
	
	@RequestMapping(value="processes/{name}", method=RequestMethod.GET)
    public List<String> findProcessesByName(@PathVariable("name") String name) {
		return fxMonitorService.findProcessesByNameLike(name).stream().map(c -> c.getName()).collect(Collectors.toList());
    }
	
	@RequestMapping(value = "resolve", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public BootstrapAlert doResolveJobs(@RequestBody JsonNode jobIdsAsJsonNode) {
		List<Integer> jobIds = toIntegerList(jobIdsAsJsonNode, "ids");
		log.info("doResolveJobs: IDs size={}", jobIds.size());
        if(jobIds.isEmpty()) {
        	return new BootstrapAlert(BootstrapAlertType.DANGER, "Parameters [ids] are missing...");
        } 
		// TODO do resolving
		return new BootstrapAlert(BootstrapAlertType.SUCCESS, "Jobs "
				+ Joiner.on(",").join(jobIds)
				+ " have been resolved.");
    }

	@RequestMapping(value = "relaunch", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public BootstrapAlert doRelaunchJobs(@RequestBody JsonNode jobIdsAsJsonNode) {
		List<Integer> jobIds = toIntegerList(jobIdsAsJsonNode, "ids");
		log.info("doRelaunchJobs: IDs size={}", jobIds.size());
        if(jobIds.isEmpty()) {
        	return new BootstrapAlert(BootstrapAlertType.DANGER, "Parameters [ids] are missing...");
        } 
		// TODO do relaunching
        return new BootstrapAlert(BootstrapAlertType.SUCCESS, "Jobs " + Joiner.on(",").join(jobIds) + " have been relaunched.");
    }
	
	private List<Integer> toIntegerList(JsonNode jobIdsAsJsonNode, String elementName) {
		List<Integer> jobIds = Lists.newArrayList();
		Iterator<JsonNode> elements = jobIdsAsJsonNode.elements();
		elements.forEachRemaining(c -> {
			jobIds.add(c.get(elementName).asInt());
		});
		return jobIds;
	}
}
