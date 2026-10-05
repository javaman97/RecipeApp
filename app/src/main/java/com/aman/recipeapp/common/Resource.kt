package com.aman.recipeapp.common

sealed interface Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>
    data class Error(val message: AppError) : Resource<Nothing>
    object Loading : Resource<Nothing>
}