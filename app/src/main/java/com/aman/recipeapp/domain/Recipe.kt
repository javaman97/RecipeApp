package com.aman.recipeapp.domain

data class RecipeSummary(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val cuisine:String,
    val difficulty: String,
    val rating: Double,
    val reviewCount: Int,
)


data class RecipeDetails(
    val caloriesPerServing: Int,
    val cookTimeMinutes: Int,
    val cuisine: String,
    val difficulty: String,
    val id: Int,
    val image: String,
    val ingredients: List<String>,
    val instructions: List<String>,
    val name: String,
    val prepTimeMinutes: Int,
    val rating: Double,
    val reviewCount: Int,
    val servings: Int,
    val tags: List<String>,
)

data class RecipePage(
    val limit: Int,
    val recipes: List<RecipeSummary>,
    val skip: Int,
    val total: Int
)