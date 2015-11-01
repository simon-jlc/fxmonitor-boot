package com.simon.fxmonitor.domain.entities;

import javax.persistence.Entity;
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
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
public class JobMessage extends AbstractEntity {
	// TODO Comprendre pourquoi l'accesseur private ne permet pas de loader les data yaml
	private static final long serialVersionUID = 6295252401126932547L;

	private String fileName;
	private String fileDescription;
	private String fileContent;
	
	@ManyToOne
	private Job job;
}
