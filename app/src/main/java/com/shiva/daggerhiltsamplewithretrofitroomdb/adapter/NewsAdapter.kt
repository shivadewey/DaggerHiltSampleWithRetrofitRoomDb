package com.shiva.daggerhiltsamplewithretrofitroomdb.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.shiva.daggerhiltsamplewithretrofitroomdb.databinding.LayoutItemNewsBinding
import com.shiva.daggerhiltsamplewithretrofitroomdb.models.Data

class NewsAdapter(
    private val context: Context,
    val list: List<Data>
) : Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(val binding: LayoutItemNewsBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutItemNewsBinding.inflate(
                LayoutInflater.from(context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {


        val data = list[position]

        Glide.with(context).load(data.imageUrl).into(holder.binding.imageView)

        holder.binding.title.text = data.title
        holder.binding.description.text = data.content
        holder.binding.date.text = data.date


    }

}