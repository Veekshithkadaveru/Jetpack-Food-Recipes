package com.example.jetpack_food_recipes.di

import com.example.jetpack_food_recipes.network.RecipeService
import com.example.jetpack_food_recipes.network.model.RecipeDtoMapper
import com.example.jetpack_food_recipes.repository.RecipeRepository
import com.example.jetpack_food_recipes.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository {
        return RecipeRepositoryImpl(recipeService, recipeDtoMapper)
    }
}