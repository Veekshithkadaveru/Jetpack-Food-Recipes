package com.example.jetpack_food_recipes.network.model

import com.example.jetpack_food_recipes.domain.model.Recipe
import com.example.jetpack_food_recipes.domain.util.EntityMapper

class RecipeDTOMapper : EntityMapper<RecipeDto, Recipe> {
    override fun mapFromEntity(entity: RecipeDto): Recipe {
        return Recipe(
            id = entity.pk,
            title = entity.title,
            featuredImage = entity.featuredImage,
            rating = entity.rating,
            publisher = entity.publisher,
            sourceUrl = entity.sourceUrl,
            dateAdded = entity.dateAdded,
            dateUpdated = entity.dateUpdated,
            ingredients = entity.ingredients
        )
    }

    override fun mapToEntity(domainModel: Recipe): RecipeDto {
        return RecipeDto(
            pk = domainModel.id,
            title = domainModel.title,
            featuredImage = domainModel.featuredImage,
            rating = domainModel.rating,
            publisher = domainModel.publisher,
            sourceUrl = domainModel.sourceUrl,
            dateAdded = domainModel.dateAdded,
            dateUpdated = domainModel.dateUpdated,
            ingredients = domainModel.ingredients
        )
    }

    fun fromEntityList(initial: List<RecipeDto>): List<Recipe> {
        return initial.map { mapFromEntity(it) }
    }

    fun toEntityList(initial: List<Recipe>): List<RecipeDto> {
        return initial.map { mapToEntity(it) }
    }
}