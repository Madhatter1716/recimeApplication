package com.example.recime.enumerated;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.stereotype.Component;


@Converter(autoApply = true)
@Component
public class DifficultyTypeConverter implements AttributeConverter<DifficultyType, String> {

	@Override
	public String convertToDatabaseColumn(DifficultyType attribute) {
		if(attribute == null) {
			return null;
		}
		
		return attribute.getType();
	}

	@Override
	public DifficultyType convertToEntityAttribute(String dbData) {
		if(dbData == null) {
			return null;
		}
		
		return Stream.of(DifficultyType.values()).filter(value -> value.getType().equals(dbData)).findFirst().orElseThrow(IllegalArgumentException::new);
	}

}
