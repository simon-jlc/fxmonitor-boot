package com.simon.fxmonitor.service.converter;

import java.util.List;

import com.google.common.collect.Lists;
import com.simon.fxmonitor.domain.entities.Process;
import com.simon.fxmonitor.service.dto.ProcessDTO;


/**
 * 
 * @since 7 déc. 2014
 * @author simon 
 */
public class ProcessConverter {
	
	public static ProcessDTO entity2dto(Process p) {
		ProcessDTO dto = new ProcessDTO();
		dto.setId(p.getId());
		dto.setName(p.getName());
		dto.setTeam(TeamConverter.entity2dto(p.getTeam()));
		dto.setCategories(CategoryConverter.entities2dtos(p.getCategories()));
		return dto; 
	}

	public static List<ProcessDTO> entities2dtos(
			List<Process> resultSet) {
		List<ProcessDTO> result = Lists.newArrayList();
		resultSet.forEach(p -> result.add(entity2dto(p)));
		return result;
	}	
}
