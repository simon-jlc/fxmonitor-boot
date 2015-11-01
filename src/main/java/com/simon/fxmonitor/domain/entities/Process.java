package com.simon.fxmonitor.domain.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @since 15 nov. 2014
 * @author simon 
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@NoArgsConstructor
public class Process extends AbstractNameEntity {
	
	private static final long serialVersionUID = -1169465875836681065L;

	@ManyToOne
	private Team team;
	
	@ManyToOne
	private Project project;
	
	@ManyToMany
	private List<Category> categories;
}
