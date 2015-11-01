package com.simon.fxmonitor.domain.entities;

import java.util.Date;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @since 13 déc. 2014
 * @author simon 
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class JobError extends AbstractEntity {
	
	private static final long serialVersionUID = -5156555861972779219L;
	
	private Date occuredDate;
	private String stackTrace;
	private String processStackTrace;
	private String errorClass;
	private String message;
	private String messageCode;
	private String specificMsg;
	private String specificMsgCode;

//	@ManyToOne
//	public JobErrorDefinition errorDefinition;
	
}
