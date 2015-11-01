package com.simon.fxmonitor.service.converter;

import com.simon.fxmonitor.domain.entities.Team;
import com.simon.fxmonitor.service.dto.TeamDTO;

/**
 * 
 * @since 7 déc. 2014
 * @author simon 
 */
public class TeamConverter {
	
	public static TeamDTO entity2dto(Team t) {
		TeamDTO dto = new TeamDTO();
		dto.setId(t.getId());
		dto.setName(t.getName());
		dto.setEmail(t.getEmail());
		return dto;
	}
}
