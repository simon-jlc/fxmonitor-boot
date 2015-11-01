package com.simon.fxmonitor.service.converter;

import java.util.List;

import com.google.common.collect.Lists;
import com.simon.fxmonitor.domain.entities.Category;
import com.simon.fxmonitor.service.dto.CategoryDTO;

/**
 * 
 * @since 7 déc. 2014
 * @author simon 
 */
public class CategoryConverter {

	public static CategoryDTO entity2dto(Category c) {
		CategoryDTO dto = new CategoryDTO();
		dto.setId(c.getId());
		dto.setName(c.getName());
		dto.setDescription(c.getDescription());
		return dto;
	}
	
	public static List<CategoryDTO> entities2dtos(List<Category> cs) {
		List<CategoryDTO> categoriesDtos = Lists.newArrayList();
		cs.forEach(c -> categoriesDtos.add(entity2dto(c)));
		return categoriesDtos;
	}
}
