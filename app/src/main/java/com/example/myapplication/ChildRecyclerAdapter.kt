package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ChildsRecyclerviewLayoutChooserBinding
import com.example.myapplication.databinding.ChildsRecyclerviewLayoutEditableBinding

class ChildRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val news = mutableListOf<ChildModel>()

    companion object {
        private const val EDITABLE_VIEWHOLDER = 1
        private const val CHOOSER_VIEWHOLDER = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == EDITABLE_VIEWHOLDER) {
            ChooserViewHolder(
                ChildsRecyclerviewLayoutChooserBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            EditableViewHolder(
                ChildsRecyclerviewLayoutEditableBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ChooserViewHolder -> holder.bind()
            is EditableViewHolder -> holder.bind()
        }
    }

    override fun getItemCount() = news.size

    inner class ChooserViewHolder(private val binding: ChildsRecyclerviewLayoutChooserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var model: ChildModel

        fun bind() {
            model = news[absoluteAdapterPosition]
            //TODO
        }
    }

    inner class EditableViewHolder(private val binding: ChildsRecyclerviewLayoutEditableBinding) :
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
