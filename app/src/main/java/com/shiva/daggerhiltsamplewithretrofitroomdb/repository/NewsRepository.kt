package com.shiva.daggerhiltsamplewithretrofitroomdb.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shiva.daggerhiltsamplewithretrofitroomdb.di.ApiInterface
import com.shiva.daggerhiltsamplewithretrofitroomdb.models.NewsData
import com.shiva.daggerhiltsamplewithretrofitroomdb.roomdb.NewsDao
import com.shiva.daggerhiltsamplewithretrofitroomdb.roomdb.NewsLocalModel
import com.shiva.daggerhiltsamplewithretrofitroomdb.utils.NetworkResult
import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiInterface: ApiInterface,
private val newsDao: NewsDao) {

    private val _newsLiveData = MutableLiveData<NetworkResult<NewsData>>()
    val newsLiveData: LiveData<NetworkResult<NewsData>>
        get() = _newsLiveData

    suspend fun getNews(category: String) {

        val response = apiInterface.getNews(category)


        if (response.isSuccessful && response.body() != null) {
            _newsLiveData.postValue(NetworkResult.Success(response.body()))
            NetworkResult.Success(response.body()).data!!.data.forEach {
                newsDao.insertNews(NewsLocalModel(0, it.title, it.content, it.date))
            }


        } else if (response.errorBody() != null) {

            _newsLiveData.postValue(NetworkResult.Error("Something went wrong"))
        } else {
            _newsLiveData.postValue(NetworkResult.Error("Something went wrong"))

        }

    }

}