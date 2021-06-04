package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private val infoLiveData = MutableLiveData<Response<List<ChildModel>>>()
        .apply {
            mutableListOf<ChildModel>()
        }

    val _infoLiveData: LiveData<Response<List<ChildModel>>> = infoLiveData


    fun initData(){
        viewModelScope.launch {
            val data = withContext(Dispatchers.Main){
                RetrofitService.retrofitService().getItems()
            }
            _infoLiveData.postValue(data)
        }
    }
}
