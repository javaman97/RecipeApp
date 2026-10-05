package com.aman.recipeapp.data

import com.aman.recipeapp.common.Resource
import com.aman.recipeapp.data.mapper.toDetail
import com.aman.recipeapp.data.mapper.toDomain
import com.aman.recipeapp.data.remote.RecipeApi
import com.aman.recipeapp.domain.RecipeDetails
import com.aman.recipeapp.domain.RecipePage
import com.aman.recipeapp.domain.RecipeRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class RecipeRepositoryImpl @Inject constructor( private val api: RecipeApi) : BaseRepository(),RecipeRepository {
    override fun getRecipes(
        query: String,
        skip: Int,
        limit: Int
    ): Flow<Resource<RecipePage>> = apiFlow {
       val dto = if(query.isEmpty()){
           api.getRecipes(limit = limit, skip = skip)
       } else {
           api.searchRecipes(query = query, limit = limit, skip = skip)
       }
        dto.toDomain()
    }

    override fun getRecipe(id: Int): Flow<Resource<RecipeDetails>> = apiFlow{
     api.getRecipe(id).toDetail()
    }
}