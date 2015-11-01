package com.simon.fxmonitor.service.dto;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @since 7 déc. 2014
 * @author simon 
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class JobLightDTO extends AbstractNamedIdDTO {
	private Long linkId;
	private Date startDate;
	private Date endDate;
	private String firstCategory;
	private String status;	
}
