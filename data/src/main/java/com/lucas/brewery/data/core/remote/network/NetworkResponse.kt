package com.lucas.brewery.data.core.remote.network

sealed class NetworkResponse<out T : Any> {
    data class Success<T : Any>(val body: T) : NetworkResponse<T>()
    data class Error(val error: Throwable) : NetworkResponse<Nothing>()
}