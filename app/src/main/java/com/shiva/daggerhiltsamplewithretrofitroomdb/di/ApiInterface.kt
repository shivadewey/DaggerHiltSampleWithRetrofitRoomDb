package com.shiva.daggerhiltsamplewithretrofitroomdb.di

import com.shiva.daggerhiltsamplewithretrofitroomdb.models.NewsData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {


    @GET("news")
    suspend fun getNews(@Query("category") category: String) : Response<NewsData>


}