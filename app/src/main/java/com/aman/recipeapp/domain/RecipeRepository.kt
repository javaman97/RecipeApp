package com.aman.recipeapp.domain

import com.aman.recipeapp.common.Resource
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {

    fun getRecipes(query: String, skip: Int, limit: Int): Flow<Resource<RecipePage>>

    fun getRecipe(id: Int): Flow<Resource<RecipeDetails>>

}