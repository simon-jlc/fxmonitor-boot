package com.simon.fxmonitor.service.converter;

import java.util.List;

import com.google.common.collect.Lists;
import com.simon.fxmonitor.domain.entities.JobMessage;
import com.simon.fxmonitor.service.dto.JobMessageDTO;

/**
 * 
 * @since 7 déc. 2014
 * @author simon 
 */
public class JobMessageConverter {

	
	public static JobMessageDTO entity2dto(JobMessage jm) {
		JobMessageDTO dto = new JobMessageDTO();
		dto.setId(jm.getId());
		dto.setName(jm.getFileName());
		dto.setFileDescription(jm.getFileDescription());
//		dto.setFileContent(jm.getFileContent());
		return dto;
	}
	
	public static List<JobMessageDTO> entities2dtos(List<JobMessage> jm) {
		List<JobMessageDTO> result = Lists.newArrayList();
		jm.forEach(i -> result.add(entity2dto(i)));
		return result;
	}
}
