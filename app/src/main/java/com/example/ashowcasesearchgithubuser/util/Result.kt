package com.example.ashowcasesearchgithubuser.util

sealed class Result<out T> {
    data class Success<out T>(val data : T) : Result<T>()
    data class Failure(val throwable: Throwable?) : Result<Nothing>()
    object Loading : Result<Nothing>()
    object Empty : Result<Nothing>()
}