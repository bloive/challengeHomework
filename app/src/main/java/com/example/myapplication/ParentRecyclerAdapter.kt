package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentFirstBinding

class ParentRecyclerAdapter : RecyclerView.Adapter<ParentRecyclerAdapter.ParentViewHolder>() {

    private val news = mutableListOf<ChildModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        return ParentViewHolder(
            FragmentFirstBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ParentRecyclerAdapter.ParentViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = news.size

    inner class ParentViewHolder(private val binding: FragmentFirstBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var model: ChildModel

        fun bind() {
            model = news[absoluteAdapterPosition]
            //TODO
        }
    }

    fun setData(childList: List<ChildModel>) {
        this.news.clear()
        this.news.addAll(childList)
        notifyDataSetChanged()
    }
}