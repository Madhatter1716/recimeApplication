package com.example.recime.Factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.recime.ResponseDTO.RecipeResponse;
import com.example.recime.model.Recipe;

@Component
public class RecipeFactory {
	
	public List<RecipeResponse> listEntityToListResponse(List<Recipe> recipes){
		List<RecipeResponse> responses = new ArrayList<>();
		for(Recipe recipe : recipes) {
			responses.add(entityToResponse(recipe));
		}
		return responses;
	}
	
	public RecipeResponse entityToResponse(Recipe recipe) {
		return RecipeResponse.builder()
				.id(recipe.getId())
				.name(recipe.getName())
				.position(recipe.getPosition())
				.likes(recipe.getLikes())
				.difficulty(recipe.getDifficulty().getType())
				.imageUrl(recipe.getImageUrl())
				.build();
	}
}
