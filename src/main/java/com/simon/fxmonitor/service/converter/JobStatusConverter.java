package com.simon.fxmonitor.service.converter;

import com.simon.fxmonitor.domain.entities.JobStatus;
import com.simon.fxmonitor.service.dto.JobStatusDTO;

/**
 * 
 * @since 7 déc. 2014
 * @author simon 
 */
public class JobStatusConverter {

	public static JobStatusDTO entity2dto(JobStatus s) {
		JobStatusDTO dto = new JobStatusDTO();
		dto.setId(s.getId());
		dto.setName(s.getName());
		return dto;
	}
}
