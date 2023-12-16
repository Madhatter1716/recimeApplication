package com.example.recime.ResponseDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RecipeResponse {
	
	private Long id;
	private String name;
	private Long position;
	private Long likes;
	private String difficulty;
	private String imageUrl;

}
