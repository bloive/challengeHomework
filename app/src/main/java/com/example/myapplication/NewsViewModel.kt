package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val newsLiveData = MutableLiveData<Response<List<NewsModel>>>()
        .apply {
            mutableListOf<NewsModel>()
        }

    val _newsLiveData: LiveData<Response<List<NewsModel>>> = newsLiveData

    fun init() {
        CoroutineScope(Dispatchers.IO).launch {
            getCountries()
        }
    }

    private suspend fun getCountries() {
        val currentLoadingPageKey = 0
        val response = RetrofitService.retrofitService(currentLoadingPageKey).getNews()
        if (response.isSuccessful) {
            val items = response.body()
            newsLiveData.postValue(Response.success(items!!))
        } else {
            newsLiveData.postValue(Response.error(response.code()))
        }
        newsLiveData.postValue(Response.loading())
    }
}
