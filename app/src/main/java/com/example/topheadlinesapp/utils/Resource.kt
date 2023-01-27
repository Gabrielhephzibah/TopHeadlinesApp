package com.example.topheadlinesapp.utils

sealed class Resource<out T>(
    val data: T? = null,
    val error: Throwable? = null,
) {
    data class Error(private val mError: Throwable? = null) : Resource<Nothing>(error = mError)
    data class Success<T>(private val mData: T) : Resource<T>(data = mData)
}