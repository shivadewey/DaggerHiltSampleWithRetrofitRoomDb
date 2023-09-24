package com.shiva.daggerhiltsamplewithretrofitroomdb.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shiva.daggerhiltsamplewithretrofitroomdb.models.NewsData
import com.shiva.daggerhiltsamplewithretrofitroomdb.repository.NewsRepository
import com.shiva.daggerhiltsamplewithretrofitroomdb.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: NewsRepository)
    : ViewModel(){

    val newsLiveData: LiveData<NetworkResult<NewsData>>
        get() = repository.newsLiveData

    fun getNews(category: String){

        viewModelScope.launch {
            repository.getNews(category)
        }
    }


}