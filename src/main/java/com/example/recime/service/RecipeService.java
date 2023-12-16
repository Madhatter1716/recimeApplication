package com.example.recime.service;

import java.util.List;

import com.example.recime.ResponseDTO.RecipeResponse;

public interface RecipeService {

	List<RecipeResponse> findAllRecipe(String filter, String orderBy);
	
}
