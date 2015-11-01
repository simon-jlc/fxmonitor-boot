package com.simon.fxmonitor.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @since 7 déc. 2014
 * @author simon 
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class TeamDTO extends AbstractNamedIdDTO {
	private String email;
}
