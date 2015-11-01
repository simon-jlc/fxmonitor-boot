package com.simon.fxmonitor.service.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @since 7 déc. 2014
 * @author simon 
 */
@Getter
@Setter
public abstract class AbstractNamedIdDTO extends AbstractIdDTO {
	public String name;
}
