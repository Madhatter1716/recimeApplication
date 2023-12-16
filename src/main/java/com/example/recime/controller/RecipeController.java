package com.example.recime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.recime.ResponseDTO.RecipeResponse;
import com.example.recime.service.RecipeService;

@RestController
@RequestMapping("/api/v1")
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;
	
	@GetMapping("/recipe")
	public ResponseEntity<List<RecipeResponse>> getRecipe(
			@RequestParam(value="filter", required = false) String filter,
			@RequestParam(value="orderBy", required = false) String orderBy){
		List<RecipeResponse> response = recipeService.findAllRecipe(filter, orderBy);
		return ResponseEntity.ok(response);
	}

}
