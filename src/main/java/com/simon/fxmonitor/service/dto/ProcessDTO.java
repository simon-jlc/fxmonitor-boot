package com.simon.fxmonitor.service.dto;

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
public class ProcessDTO extends AbstractNamedIdDTO {
	private TeamDTO team;
	private List<CategoryDTO> categories;
}
