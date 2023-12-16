package com.example.recime.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.recime.Factory.RecipeFactory;
import com.example.recime.ResponseDTO.RecipeResponse;
import com.example.recime.enumerated.DifficultyType;
import com.example.recime.exception.RecipeException;
import com.example.recime.model.Recipe;
import com.example.recime.repository.RecipeRepository;
import com.example.recime.repository.criteria.RecipeCriteria;
import com.example.recime.service.RecipeService;

import liquibase.repackaged.org.apache.commons.lang3.StringUtils;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	RecipeRepository recipeRepo;

	@Autowired
	RecipeFactory recipeFactory;
	
	@Autowired
	RecipeCriteria recipeCriteria;

	@Override
	public List<RecipeResponse> findAllRecipe(String filter, String orderBy) {
		if(StringUtils.isNoneBlank(filter) && 
				!(filter.equals(DifficultyType.EASY.getType()) 
				|| filter.equals(DifficultyType.MEDIUM.getType()) 
				|| filter.equals(DifficultyType.HARD.getType()))) {
			throw new RecipeException("A difficulty is required for filtering trending recipes");
		}
		
		List<Recipe> recipe = recipeCriteria.getRecipes(filter, orderBy);

		return recipeFactory.listEntityToListResponse(recipe);
	}

}
