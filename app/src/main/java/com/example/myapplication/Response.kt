package com.example.myapplication

data class Response<T>(val status: Status, val data: T? = null, val code: Int? = null) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): Response<T> {
            return Response(Status.SUCCESS, data)
        }

        fun <T> error(code: Int?): Response<T> {
            return Response(Status.ERROR, null, code)
        }

        fun <T> loading(): Response<T> {
            return Response(Status.LOADING)
        }
    }
}

