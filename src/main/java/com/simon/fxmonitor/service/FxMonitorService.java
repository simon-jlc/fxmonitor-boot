package com.simon.fxmonitor.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.simon.fxmonitor.domain.entities.AbstractNameEntity;
import com.simon.fxmonitor.domain.entities.Category;
import com.simon.fxmonitor.domain.entities.Job;
import com.simon.fxmonitor.domain.entities.Process;
import com.simon.fxmonitor.domain.entities.Project;
import com.simon.fxmonitor.domain.repositories.CategoryRepository;
import com.simon.fxmonitor.domain.repositories.JobRepository;
import com.simon.fxmonitor.domain.repositories.ProcessRepository;
import com.simon.fxmonitor.service.converter.CategoryConverter;
import com.simon.fxmonitor.service.converter.JobConverter;
import com.simon.fxmonitor.service.converter.ProcessConverter;
import com.simon.fxmonitor.service.dto.CategoryDTO;
import com.simon.fxmonitor.service.dto.JobDTO;
import com.simon.fxmonitor.service.dto.JobLightDTO;
import com.simon.fxmonitor.service.dto.ProcessDTO;

/**
 * 
 * @since 27 août 2015
 * @author simon
 * 
 *  TODO Split this class
 *  
 */
@Service("fxMonitorService")
public class FxMonitorService {

	@Autowired JobRepository jobRepository;
	
	@Autowired CategoryRepository categoryRepository;
	
	@Autowired ProcessRepository processRepository;
	
	public List<JobsStatistics> getStatisticsByProject() {
		// load datas
		Iterable<Job> jobsIterable = jobRepository.findAll();
		List<Job> jobs = Lists.newArrayList(jobsIterable);

		// Group by Project
		Function<Job, Project> groupJobByProject = j -> j.getProcess().getProject();
		return getStatisticsBy(jobs, groupJobByProject);
	}
	
	public List<JobsStatistics> getStatisticsByCategory(Long projectId) {
		// load jobs
		List<Job> jobs = jobRepository.findJobByProcessProject(new Project(projectId));
		// use dedicated grouping function
		Function<Job, Category> groupJobByCategory = j -> j.getProcess()
				.getCategories().stream().findFirst().get();
		return getStatisticsBy(jobs, groupJobByCategory);
    }
	
	public List<JobLightDTO> findAllJobs() {
		List<Job> jobs = Lists.newArrayList(jobRepository.findAll());
		return JobConverter.entities2LightDtos(jobs);
	}
	
	public CategoryDTO findCategoryByName(String name) {
		Optional<Category> resultSet = categoryRepository.findByName(name.toLowerCase());
		if(!resultSet.isPresent()) return null;
		return CategoryConverter.entity2dto(resultSet.get());
	}
	
	public List<CategoryDTO> findCategoriesByNameLike(String name) {
		List<Category> resultSet = categoryRepository.findByNameLikeIgnoreCase("%" + name + "%");
		return CategoryConverter.entities2dtos(resultSet);
	}
	
	public List<ProcessDTO> findProcessesByNameLike(String name) {
		List<Process> resultSet = processRepository.findByNameLikeIgnoreCase("%" + name + "%");
		return ProcessConverter.entities2dtos(resultSet);
	}

	public JobDTO findJobDetailsById(Long id) {
		Job oneJob = jobRepository.findOne(id);
		return JobConverter.entity2dto(oneJob);
	}
	
	private <T extends AbstractNameEntity> List<JobsStatistics> getStatisticsBy(List<Job> jobs, Function<Job, T> function) {
		// init result variables
		List<JobsStatistics> result = Lists.newArrayList();
		Map<T, List<Job>> jobByProject = jobs.stream()
				.collect(Collectors.groupingBy(function));
		
		// Populate job statistaics
		jobByProject.forEach(
			(k, v) -> result.add(toJobsStatistics(k, v.stream()
				.collect(Collectors.groupingBy(j -> j.getJobStatus().getName())))));
		
		return result;
	}
	
	private <T extends AbstractNameEntity> JobsStatistics toJobsStatistics(T nameEntity,
			Map<String, List<Job>> jobsByStatus) {
		return toJobsStatistics(nameEntity.getName(), nameEntity.getId().intValue(), jobsByStatus);
	}

	private JobsStatistics toJobsStatistics(String name, Integer id,
			Map<String, List<Job>> jobsByStatus) {
		// TODO add enumeration
		int success = jobsByStatus.get("Success") != null ? jobsByStatus.get("Success").size() : 0;
		success += jobsByStatus.get("Resolved") != null ? jobsByStatus.get("Resolved").size() : 0;
		int errors = jobsByStatus.get("Failed") != null ? jobsByStatus.get("Failed").size() : 0;
		int warnings = jobsByStatus.get("Partially success") != null ? jobsByStatus.get("Partially success").size() : 0;
		return new JobsStatistics()
			.withId(id)
			.withName(name)
			.withErrors(errors)
			.withSuccess(success)
			.withWarnings(warnings);
	}
}
