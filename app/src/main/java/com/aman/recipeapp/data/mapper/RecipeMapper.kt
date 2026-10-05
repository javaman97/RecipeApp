package com.aman.recipeapp.data.mapper

import com.aman.recipeapp.common.AppError
import com.aman.recipeapp.data.dto.RecipeDto
import com.aman.recipeapp.data.dto.RecipePageDto
import com.aman.recipeapp.domain.RecipeDetails
import com.aman.recipeapp.domain.RecipePage
import com.aman.recipeapp.domain.RecipeSummary

fun RecipeDto.toSummaryOrNull(): RecipeSummary?{
    val id = id ?: return null
    val name = name ?: return null
    val image = image ?: return null
    return RecipeSummary(  id = id,
        name = name,
        imageUrl = image,
        cuisine = cuisine.orEmpty(),
        difficulty = difficulty.orEmpty(),
        rating = rating ?: 0.0,
        reviewCount = reviewCount ?: 0,)
}

fun RecipeDto.toDetail(): RecipeDetails {
    val id = id ?: throw AppError.BadResponse
    val name = name ?: throw AppError.BadResponse
    return RecipeDetails(
        id = id,
        name = name,
        image = image.orEmpty(),
        cuisine = cuisine.orEmpty(),
        difficulty = difficulty.orEmpty(),
        rating = rating ?: 0.0,
        reviewCount = reviewCount ?: 0,
        prepTimeMinutes = prepTimeMinutes ?: 0,
        cookTimeMinutes = cookTimeMinutes ?: 0,
        servings = servings ?: 0,
        caloriesPerServing = caloriesPerServing ?: 0,
        ingredients = ingredients.orEmpty(),
        instructions = instructions.orEmpty(),
        tags = tags.orEmpty(),
    )}

fun RecipePageDto.toDomain(): RecipePage{
    val recipes = recipes?.mapNotNull { it.toSummaryOrNull() } ?: emptyList()
    return RecipePage(
        recipes = recipes,
        total = total ?: recipes.size,
        skip = 0,
        limit = 30
    )
}