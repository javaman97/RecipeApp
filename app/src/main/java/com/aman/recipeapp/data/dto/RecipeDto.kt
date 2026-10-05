package com.aman.recipeapp.data.dto

data class RecipePageDto(
    val recipes: List<RecipeDto>?,
    val total: Int?,
)
data class RecipeDto(
    val id: Int?,
    val name: String?,
    val image: String?,
    val cuisine: String?,
    val difficulty: String?,
    val rating: Double?,
    val reviewCount: Int?,
    val prepTimeMinutes: Int?,
    val cookTimeMinutes: Int?,
    val servings: Int?,
    val caloriesPerServing: Int?,
    val ingredients: List<String>?,
    val instructions: List<String>?,
    val tags: List<String>?,
)