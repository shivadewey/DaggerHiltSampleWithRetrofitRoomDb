package com.shiva.daggerhiltsamplewithretrofitroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import androidx.activity.viewModels
import com.shiva.daggerhiltsamplewithretrofitroomdb.adapter.NewsAdapter
import com.shiva.daggerhiltsamplewithretrofitroomdb.databinding.ActivityMainBinding
import com.shiva.daggerhiltsamplewithretrofitroomdb.viewmodels.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private val  newsViewModel by viewModels<NewsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        newsViewModel.newsLiveData.observe(this){
            binding.progressBar.visibility = GONE
             binding.recyclerView.adapter = NewsAdapter(this, it.data!!.data)
        }


        newsViewModel.getNews("movie")


    }
}