package com.simon.fxmonitor.domain.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

/**
 * 
 * @since 15 nov. 2014
 * @author simon 
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Wither
@Entity
public class Job  extends AbstractEntity {
	
	private static final long serialVersionUID = -166500378002561360L;

	private Date startTime;
	private Date endTime;
	
	@ManyToOne
	private Process process;
	
	@ManyToOne
	private JobStatus jobStatus;
	
	@OneToOne
	private JobError jobError;
	
	@OneToMany(mappedBy="job", cascade=CascadeType.ALL)
	private List<JobMessage> messages;
	
//	@OneToMany(cascade=CascadeType.ALL)
//	private List<JobFilter> jobFilters;
}
