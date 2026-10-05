package com.aman.recipeapp.common

sealed class AppError: Exception(){
    data object NoInternet : AppError()
    data object Unknown : AppError()
    data class HttpError(val code: Int) : AppError()
    data object BadResponse : AppError()
    data object Timeout : AppError()
}