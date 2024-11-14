package com.example.jetpack_food_recipes.repository

import com.example.jetpack_food_recipes.domain.model.Recipe
import com.example.jetpack_food_recipes.network.RecipeService
import com.example.jetpack_food_recipes.network.model.RecipeDtoMapper

class RecipeRepositoryImpl(
    private val recipeService: RecipeService,
    private val mapper: RecipeDtoMapper
) : RecipeRepository {
    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(recipeService.search(token, page, query).recipes)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeService.get(token, id))
    }
}