package com.simon.fxmonitor.service.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @since 7 déc. 2014
 * @author simon 
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class JobDTO extends AbstractIdDTO {
	
	private Long linkedId;
	private Date startDate;
	private Date endDate;
	
	private ProcessDTO process;
	private JobStatusDTO jobStatus;
	private List<JobMessageDTO> messages;
	
}
