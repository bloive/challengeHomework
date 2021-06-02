package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemNewsRecyclerviewLayoutBinding

class NewsRecyclerViewAdapter : RecyclerView.Adapter<NewsRecyclerViewAdapter.WallPostsViewHolder>() {

    private val news = mutableListOf<NewsModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallPostsViewHolder {
        return WallPostsViewHolder(
            ItemNewsRecyclerviewLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsRecyclerViewAdapter.WallPostsViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = news.size

    inner class WallPostsViewHolder(private val binding: ItemNewsRecyclerviewLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var model: NewsModel

        fun bind() {
            model = news[adapterPosition]
            binding.titleTextView.text = model.titleKA
            Glide.with(binding.newsCoverImageView.context)
                .load(model.cover)
                .into(binding.newsCoverImageView)
        }
    }

    fun setData(newsList: List<NewsModel>) {
        this.news.clear()
        this.news.addAll(newsList)
        notifyDataSetChanged()
    }
}
