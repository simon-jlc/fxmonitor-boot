package com.simon.fxmonitor.domain.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.simon.fxmonitor.AbstractFxMonitorApplicationTest;
import com.simon.fxmonitor.domain.entities.Category;

/**
 * 
 * @since 26 août 2015
 * @author simon
 */
public class CategoryRepositoryTest extends AbstractFxMonitorApplicationTest {

	@Autowired
	CategoryRepository repository;

	@Test
	public void invokesDefaultMethod() {

		Category category = repository.save(new Category("Test", "Insert a new row"));
		Optional<Category> findByNameCategory = repository.findByName("Test");

		assertThat(findByNameCategory.isPresent()).isTrue();
		assertThat(findByNameCategory.get().getDescription()).isEqualTo(
				category.getDescription());
	}

	@Test
	public void findInsertedDataAfterApplicationStarted() {

		String expectedDescription = "Contains all swift flows";
		Optional<Category> findByNameCategory = repository
				.findByName("Swift");

		assertThat(findByNameCategory.isPresent()).isTrue();
		assertThat(findByNameCategory.get().getDescription()).isEqualTo(
				expectedDescription);
	}
	
	@Test
	public void shouldReturnAllCategoriesWhenNameMatch() {
		List<Category> findByLikeNameIgnoreCase = repository.findByNameLikeIgnoreCase("%SWI%");
		assertThat(findByLikeNameIgnoreCase).isNotEmpty();
		assertThat(findByLikeNameIgnoreCase.size()).isEqualTo(1);
	}
}
