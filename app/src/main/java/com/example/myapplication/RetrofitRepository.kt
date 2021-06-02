package com.example.myapplication

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitRepository {
    @GET("/api/m/v2")
    suspend fun getNews( @Query("page") query: Int) : Response<List<NewsModel>>
}