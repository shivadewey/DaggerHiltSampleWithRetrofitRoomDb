package com.shiva.daggerhiltsamplewithretrofitroomdb.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class NewsLocalModel (

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title : String,
    val description : String,
    val date : String)
