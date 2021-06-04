package com.example.myapplication

import retrofit2.http.GET

interface RetrofitRepository {
    @GET("/v3/d531f5f5-180d-4364-bae7-791dae87f732?fbclid=IwAR0Qhj1NaWXUnQGC-QyTsYXLjrp4FJ4MJCSToe0BseT0HSj5XWIsRR5XvTY")
    suspend fun getItems() : Response<List<ChildModel>>
}