package com.simon.fxmonitor.domain.entities;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
 * @since 27 août 2015
 * @author simon 
 */
@MappedSuperclass
@Getter
@NoArgsConstructor
public abstract class AbstractNameEntity extends AbstractEntity {

	String name;
	
	public AbstractNameEntity(Long id) {
		super(id);
	}
	
	public AbstractNameEntity(String name) {
		this.name = name;
	}
	
	public AbstractNameEntity(Long id, String name) {
		super(id);
		this.name = name;
	}
}
