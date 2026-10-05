package com.aman.recipeapp.data.remote

import com.aman.recipeapp.data.dto.RecipeDto
import com.aman.recipeapp.data.dto.RecipePageDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeApi {
    @GET("recipes")
    suspend fun getRecipes(
        @Query("limit") limit: Int,
        @Query("skip") skip: Int,
        @Query("select") search: String? = LIST_FIELDS,
    ): RecipePageDto

    @GET("recipes/search")
    suspend fun searchRecipes(
        @Query("q") query: String,
        @Query("limit") limit: Int,
        @Query("skip") skip: Int,
        @Query("select") select: String = LIST_FIELDS, ): RecipePageDto

    @GET("recipes/{id}")
    suspend fun getRecipe(@Path("id") id: Int): RecipeDto

    private companion object {
        const val LIST_FIELDS = "_id, title, image, cookingTime, ingredients"
    }

}