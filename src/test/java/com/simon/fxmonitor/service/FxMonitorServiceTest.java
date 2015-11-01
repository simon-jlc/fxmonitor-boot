package com.simon.fxmonitor.service;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.simon.fxmonitor.AbstractFxMonitorApplicationTest;
import com.simon.fxmonitor.domain.entities.Job;
import com.simon.fxmonitor.domain.repositories.JobRepository;
import com.simon.fxmonitor.service.dto.CategoryDTO;
import com.simon.fxmonitor.service.dto.JobLightDTO;


/**
 * 
 * @since 29 août 2015
 * @author simon 
 */
public class FxMonitorServiceTest extends AbstractFxMonitorApplicationTest {
	
	@Autowired FxMonitorService fxMonitorService;
	
	@Autowired JobRepository jobRepository;

	@Test
	public void shouldReturnJobsStatisticsByProject() {
		List<JobsStatistics> jobsStatisticsByProject = fxMonitorService.getStatisticsByProject();
		assertThat(jobsStatisticsByProject).isNotEmpty();
		assertThat(jobsStatisticsByProject.size()).isEqualTo(1); // update according project size
	}
	
	@Test
	public void shouldReturnJobsStatisticsByCategories() {
		List<JobsStatistics> jobsStatisticsByCategories = fxMonitorService.getStatisticsByCategory(1L);
		assertThat(jobsStatisticsByCategories).isNotEmpty();
		assertThat(jobsStatisticsByCategories.size()).isEqualTo(1); // update according categories in 1st projects
	}
	
	@Test
	public void shouldReturnAllLightJobs() {
		List<Job> expectedJobs = Lists.newArrayList(jobRepository.findAll());
		List<JobLightDTO> findAllLightJobs = fxMonitorService.findAllJobs();
		assertThat(findAllLightJobs.size()).isEqualTo(expectedJobs.size());
	}
	
	@Test
	public void shouldReturnNullWhenCategoryIsNotFound() {
		String name = "test";
		CategoryDTO findCategoryByName = fxMonitorService.findCategoryByName(name);
		assertThat(findCategoryByName).isNull();
	}
	
	@Test
	public void shouldReturnCategoryWhenCategoryIsFound() {
		String name = "Swift";
		CategoryDTO findCategoryByName = fxMonitorService.findCategoryByName(name);
		assertThat(findCategoryByName).isNotNull();
		assertThat(findCategoryByName.getName()).isEqualTo(name);
	}
	
	@Test
	public void shouldReturnCategoriesWhenCategoriesMatch() {
		String name = "Swift";
		CategoryDTO findCategoryByName = fxMonitorService.findCategoryByName(name);
		assertThat(findCategoryByName).isNotNull();
		assertThat(findCategoryByName.getName()).isEqualTo(name);
	}
}
