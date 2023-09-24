package com.shiva.daggerhiltsamplewithretrofitroomdb.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NewsLocalModel::class ], version = 1)
abstract class MyDatabase: RoomDatabase() {
    abstract fun getNewsDao() : NewsDao
}