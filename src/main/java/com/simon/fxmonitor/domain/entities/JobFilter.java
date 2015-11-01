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
@NoArgsConstructor
@Entity
public class JobFilter extends AbstractNameEntity {
	
	private static final long serialVersionUID = 6559814290316685042L;

}
