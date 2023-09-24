package com.shiva.daggerhiltsamplewithretrofitroomdb.di

import android.content.Context
import androidx.room.Room
import com.shiva.daggerhiltsamplewithretrofitroomdb.roomdb.MyDatabase
import com.shiva.daggerhiltsamplewithretrofitroomdb.roomdb.NewsDao
import com.shiva.daggerhiltsamplewithretrofitroomdb.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class AppModule {


    @Provides
    fun getApiInterface() : ApiInterface{

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build().create(ApiInterface::class.java)
    }

    @Provides
    fun providesNewsDao(myDatabase:  MyDatabase) :NewsDao{
        return myDatabase.getNewsDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext : Context) : MyDatabase{
        return Room.databaseBuilder(appContext,
        MyDatabase::class.java,
            "papayacoders"
        ).build()

    }


}