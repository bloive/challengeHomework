package com.example.myapplication

import androidx.paging.PagingSource
import androidx.paging.PagingState

class PostDataSource(private val apiSevice: RetrofitRepository) : PagingSource<Int, NewsModel>() {
    override fun getRefreshKey(state: PagingState<Int, NewsModel>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsModel> {
        try {
            val currentLoadingPageKey = params.key ?: 1
            val response = RetrofitService.retrofitService(currentLoadingPageKey)
            //TODO
//            return LoadResult.Page()
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

}