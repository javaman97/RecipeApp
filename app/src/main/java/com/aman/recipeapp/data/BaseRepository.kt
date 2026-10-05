package com.aman.recipeapp.data

import com.aman.recipeapp.common.AppError
import com.aman.recipeapp.common.Resource
import com.google.api.Http
import com.google.gson.JsonParseException
import java.io.IOException
import java.net.SocketTimeoutException
import kotlin.coroutines.cancellation.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

abstract class BaseRepository {

    protected fun <T> apiFlow(call:suspend () -> T): Flow<Resource<T>> = flow {

        emit(Resource.Loading)

        val result = try {
            Resource.Success(safeApiCall(call))
        } catch (e: AppError) {
            Resource.Error(e)
        }

        emit(result)
    }

    private suspend fun <T> safeApiCall(call:suspend () -> T): T = try {
        call()
    } catch (e: CancellationException) {
        throw e
    } catch (e: AppError) {
        throw e
    } catch (e: SocketTimeoutException) { // before IOException: it is a subclass
        throw AppError.Timeout
    } catch (e: IOException) {
        throw AppError.NoInternet
    } catch (e: HttpException) {
        throw AppError.HttpError(e.code())
    } catch (e: JsonParseException) {
        throw AppError.BadResponse
    } catch (e: Exception) {
        throw AppError.Unknown
    }

}