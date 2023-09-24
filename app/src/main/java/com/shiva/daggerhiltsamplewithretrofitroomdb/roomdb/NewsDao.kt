package com.shiva.daggerhiltsamplewithretrofitroomdb.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NewsDao {

    @Insert
    suspend fun insertNews(news : NewsLocalModel)

    @Query("SELECT * FROM NewsLocalModel")
    fun getNews() : LiveData<List<NewsLocalModel>>

}