package com.simon.fxmonitor.domain.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.simon.fxmonitor.domain.entities.Process;

/**
 * 
 * @since 29 août 2015
 * @author simon 
 */
public interface ProcessRepository extends CrudRepository<Process, Long> {

	List<Process> findByNameLikeIgnoreCase(String name);
	
}
