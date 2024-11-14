package com.example.jetpack_food_recipes.repository

import com.example.jetpack_food_recipes.domain.model.Recipe

interface RecipeRepository {

    suspend fun search(token: String, page: Int, query: String): List<Recipe>

    suspend fun get(token: String, id: Int): Recipe
}