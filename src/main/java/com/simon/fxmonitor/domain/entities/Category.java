package com.simon.fxmonitor.domain.entities;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
 * @since 15 nov. 2014
 * @author simon 
 */
@EqualsAndHashCode(callSuper=false)
@Getter
@NoArgsConstructor
@Entity
public class Category extends AbstractNameEntity{

	static final long serialVersionUID = -6627869446767223581L;
	String description;
	
	public Category(Long id) {
		super(id);
	}
	
	public Category(String name, String description) {
		super(name);
		this.description = description;
	}
	
	public Category(Long id, String name, String description) {
		super(id, name);
		this.description = description;
	}
}
