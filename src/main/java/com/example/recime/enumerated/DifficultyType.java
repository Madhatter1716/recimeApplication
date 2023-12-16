package com.example.recime.enumerated;

public enum DifficultyType {

	EASY("easy"), MEDIUM("medium"), HARD("hard");

	private String type;

	private DifficultyType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
