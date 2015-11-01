package com.simon.fxmonitor.service.converter;

import java.util.List;

import com.google.common.collect.Lists;
import com.simon.fxmonitor.domain.entities.Job;
import com.simon.fxmonitor.service.dto.JobDTO;
import com.simon.fxmonitor.service.dto.JobLightDTO;

/**
 * 
 * @since 7 déc. 2014
 * @author simon 
 */
public class JobConverter {

	public static JobLightDTO entity2LightDTO(Job j) {
		JobLightDTO dto = new JobLightDTO();
		dto.setId(j.getId());
		dto.setLinkId(j.getId());
		dto.setName(j.getProcess().getName());
		dto.setStartDate(j.getStartTime());
		dto.setEndDate(j.getEndTime());
		dto.setStatus(j.getJobStatus().getName());
		// FIXME modify algorithm following statement to retrieve first
		dto.setFirstCategory(j.getProcess().getCategories().get(0).getName());
		return dto;
	}
	
	public static List<JobLightDTO> entities2LightDtos(List<Job> jobs) {
		List<JobLightDTO> result = Lists.newArrayList();
		jobs.forEach(j -> result.add(entity2LightDTO(j)));
		return result;
	}
	
	public static JobDTO entity2dto(Job j) {
		JobDTO dto = new JobDTO();
		dto.setId(j.getId());
		dto.setLinkedId(j.getId());
		dto.setStartDate(j.getStartTime());
		dto.setEndDate(j.getEndTime());
		dto.setJobStatus(JobStatusConverter.entity2dto(j.getJobStatus()));
		dto.setProcess(ProcessConverter.entity2dto(j.getProcess()));
		dto.setMessages(JobMessageConverter.entities2dtos(j.getMessages()));
		return dto;
	}
}
