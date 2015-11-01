package com.simon.fxmonitor.domain.entities;

import javax.persistence.Entity;

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
@Entity
@NoArgsConstructor
public class JobStatus extends AbstractNameEntity {
	
	private static final long serialVersionUID = -6144436521663650252L;
	
}
