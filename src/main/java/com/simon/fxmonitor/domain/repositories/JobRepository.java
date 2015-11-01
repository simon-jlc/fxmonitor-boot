package com.simon.fxmonitor.domain.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.simon.fxmonitor.domain.entities.Category;
import com.simon.fxmonitor.domain.entities.Job;
import com.simon.fxmonitor.domain.entities.Project;

/**
 * 
 * @since 26 août 2015
 * @author simon 
 */
public interface JobRepository extends CrudRepository<Job, Long> {

//	@Query(value = "select top 100 j.*, sum(po.quantity) as total_quantity from product p " +
//	        "inner join productorder po " +
//	            "on p.id = po.product_id " +
//	        "group by p.id, p.name " +
//	        "order by total_quantity desc", nativeQuery = true)
//	List<Job> findTop100JobStatistics();

	List<Job> findJobByProcessCategories(Category category);
	
	List<Job> findJobByProcessProject(Project project);
}
