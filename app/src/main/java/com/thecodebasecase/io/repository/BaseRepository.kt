package com.thecodebasecase.io.repository

import com.google.gson.Gson
import com.thecodebasecase.io.common.Resource

open class BaseRepository {
    suspend fun <T : Any> apiCall(call: suspend () -> retrofit2.Response<T>): Resource<T> {
        return try {
            val response = call()
            if (response.isSuccessful) {
                Resource.Success(response.body()!!)
            } else {
                val errorBody = response.errorBody()?.string()
                val errorResponse = convertErrorBody(errorBody)
                Resource.Error(errorResponse?.errorMessage ?: "An unknown error occurred")
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }

    private fun convertErrorBody(errorBody: String?): ErrorBody? {
        return try {
            errorBody?.let {
                val gson = Gson()
                gson.fromJson(it, ErrorBody::class.java)
            }
        } catch (e: Exception) {
            null
        }
    }
}

data class ErrorBody(
    val errorCode: Int?,
    val errorMessage: String?
)

