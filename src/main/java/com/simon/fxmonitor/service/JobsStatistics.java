package com.simon.fxmonitor.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

/**
 * 
 * @since 27 août 2015
 * @author simon 
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Wither
public class JobsStatistics {

	private int id;
	private String name;
	private int success;
	private int warnings;
	private int errors;
	
}
