package com.simon.fxmonitor.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @since 13 déc. 2014
 * @author simon 
 */

@Data
@EqualsAndHashCode(callSuper=false)
public class CountOverviewDTO extends AbstractNamedIdDTO {
	public Integer success;
	public Integer errors;
	public Integer warnings;
}
