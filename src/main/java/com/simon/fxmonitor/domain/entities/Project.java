package com.simon.fxmonitor.domain.entities;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @since 13 déc. 2014
 * @author simon 
 */

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@NoArgsConstructor
public class Project extends AbstractNameEntity {
	
	private static final long serialVersionUID = 2681156853088847563L;
	
	public Project(Long id) {
		super(id);
	}
	
//	public Project(Long id, String name)
	
}
