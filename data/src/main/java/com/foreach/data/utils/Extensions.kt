package com.foreach.data.utils

import android.util.Log
import com.foreach.entities.ApiException
import com.foreach.entities.Result
import retrofit2.Response
import java.lang.Exception

suspend fun <R> makeApiCall(
        call: suspend () -> com.foreach.entities.Result<R>,
        errorCode: Int = 4567
) = try {
    call()
} catch (e: Exception) {
    Log.i("makeApiCall", "makeApiCall: ${e.message}")
    com.foreach.entities.Result.Error(ApiException(errorCode,e.message,null))
}

fun <R> analyzeResponse(
        response: Response<R>
): com.foreach.entities.Result<R> {
    return when {
        response.isSuccessful -> {
            com.foreach.entities.Result.Success(response.body())
        }
        else -> {
            Result.Error(ApiException(response.code(),response.message(),response.errorBody()!!))
        }
    }
}

