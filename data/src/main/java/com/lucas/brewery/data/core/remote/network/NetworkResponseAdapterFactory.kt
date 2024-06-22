package com.lucas.brewery.data.core.remote.network

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class NetworkResponseAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {

        if (Call::class.java != getRawType(returnType)) {
            return null
        }

        if (returnType !is ParameterizedType) {
            throw IllegalStateException("Call must be parameterized")
        }

        val responseType = getParameterUpperBound(0, returnType)

        if (getRawType(responseType) != NetworkResponse::class.java) {
            return null
        }

        if (responseType !is ParameterizedType) {
            throw IllegalStateException("Response must be parameterized")
        }

        val successBodyType = getParameterUpperBound(0, responseType)

        return NetworkResponseAdapter<Any>(successBodyType)
    }
}