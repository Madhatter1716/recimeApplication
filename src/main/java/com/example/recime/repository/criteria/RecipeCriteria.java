package com.example.recime.repository.criteria;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.recime.model.Recipe;
import com.example.recime.repository.RecipeRepository;

import liquibase.repackaged.org.apache.commons.lang3.StringUtils;

@Component
public class RecipeCriteria {

	@Autowired
	RecipeRepository recipeRepo;

	@Autowired
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Recipe> getRecipes(String filter, String orderBy) {
		StringJoiner stringQuery = new StringJoiner("\n");
		stringQuery.add("SELECT * FROM recipe");
		
		if (StringUtils.isNoneBlank(filter)) {
			stringQuery.add("WHERE difficulty = :filter");
		}
		if (Objects.nonNull(orderBy)) {
			stringQuery.add("ORDER BY " + orderBy);
		}
		Query query = this.entityManager.createNativeQuery(stringQuery.toString(), Recipe.class);
		if (StringUtils.isNoneBlank(filter))
			query.setParameter("filter", filter);
		

		return (List<Recipe>) query.getResultList();

	}

}
