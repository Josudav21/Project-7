package com.example.util

sealed class Resource<T>(val data: T? = null, val message: String) {
    class Ok<T>(data: T, msg: String): Resource<T>(data, msg)
    class Failed<T>(msg: String): Resource<T>(message = msg)
}
