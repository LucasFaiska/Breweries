package com.lucas.breweries.data.core.remote.network

import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkResponseCall<S : Any>(private val delegate: Call<S>) :
    Call<NetworkResponse<S>> {
    override fun clone(): Call<NetworkResponse<S>> {
        return NetworkResponseCall(delegate.clone())
    }

    override fun execute(): Response<NetworkResponse<S>> {
        throw UnsupportedOperationException("NetworkResponseCall doesn't support execute")
    }

    override fun isExecuted(): Boolean {
        return delegate.isExecuted
    }

    override fun cancel() {
        delegate.cancel()
    }

    override fun isCanceled(): Boolean {
        return delegate.isCanceled
    }

    override fun request(): Request {
        return delegate.request()
    }

    override fun timeout(): Timeout {
        return delegate.timeout()
    }

    override fun enqueue(callback: Callback<NetworkResponse<S>>) {
        delegate.enqueue(object : Callback<S> {
            override fun onResponse(call: Call<S>, response: Response<S>) {
                val networkResponse = getNetworkResponse(response)

                callback.onResponse(
                    this@NetworkResponseCall,
                    Response.success(networkResponse)
                )
            }

            override fun onFailure(call: Call<S>, throwable: Throwable) {
                callback.onResponse(
                    this@NetworkResponseCall,
                    Response.success(NetworkResponse.Error(throwable))
                )
            }
        })
    }

    private fun getNetworkResponse(response: Response<S>): NetworkResponse<S> {
        return if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                NetworkResponse.Success(body)
            } else {
                NetworkResponse.Error(Throwable(response.message()))
            }
        } else {
            NetworkResponse.Error(Throwable(response.message()))
        }
    }
}