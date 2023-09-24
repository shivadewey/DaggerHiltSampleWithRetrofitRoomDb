package com.shiva.daggerhiltsamplewithretrofitroomdb.models

data class NewsData(
    val category: String,
    val `data`: List<Data>,
    val success: Boolean
)