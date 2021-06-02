package com.example.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val newsLiveData = MutableLiveData<List<NewsModel>>().apply {
        mutableListOf<NewsModel>()
    }

    private val loadingLiveData = MutableLiveData<Boolean>().apply {
        true
    }

    val _loadingLiveData: LiveData<Boolean> = loadingLiveData

    val _newsLiveData: LiveData<List<NewsModel>> = newsLiveData

    fun init() {
        CoroutineScope(Dispatchers.IO).launch {
            getCountries()
        }
    }

    private suspend fun getCountries() {
        val response = RetrofitService.retrofitService().getNews(1)
        if (response.isSuccessful) {
            val items = response.body()
            items?.forEach{
                Log.d("JJJJJJJJJJ", "${it.id}")
            }
            newsLiveData.postValue(items)
        } else {
            response.code()
        }
        loadingLiveData.postValue(false)
    }
}
