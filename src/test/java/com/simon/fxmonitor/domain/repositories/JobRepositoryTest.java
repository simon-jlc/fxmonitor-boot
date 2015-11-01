package com.simon.fxmonitor.domain.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.simon.fxmonitor.AbstractFxMonitorApplicationTest;
import com.simon.fxmonitor.domain.entities.Category;
import com.simon.fxmonitor.domain.entities.Job;

/**
 * 
 * @since 26 août 2015
 * @author simon
 */
public class JobRepositoryTest extends AbstractFxMonitorApplicationTest {

	@Autowired
	JobRepository jobRepository;

	@Test
	public void invokeDefaultMethod() {
		Iterable<Job> findAllJobs = jobRepository.findAll();
		List<Job> newList = Lists.newArrayList(findAllJobs);
		assertThat(newList).isNotEmpty();
	}
	
	@Test
	public void invokeFindJobByProcessCategory() {
		Category category = new Category(Long.valueOf(1));
		Iterable<Job> findAllJobs = jobRepository.findJobByProcessCategories(category);
		List<Job> newList = Lists.newArrayList(findAllJobs);
		assertThat(newList).isNotEmpty();
	}
}
