package com.example.topheadlinesapp.ui.headlines

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.topheadlinesapp.data.model.local.HeadLinesItem
import com.example.topheadlinesapp.databinding.HeadlinesItemsBinding

class HeadLinesAdapter (private val onItemClick: (HeadLinesItem?) -> Unit) :
    ListAdapter<HeadLinesItem, HeadLinesViewHolder>(HeadLinesComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadLinesViewHolder {
        val binding =
            HeadlinesItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return HeadLinesViewHolder(binding) {
            onItemClick(getItem(it))
        }
    }

    override fun onBindViewHolder(holder: HeadLinesViewHolder, position: Int) {
        getItem(position)?.let { item -> holder.bind(item) }
    }


    object HeadLinesComparator : DiffUtil.ItemCallback<HeadLinesItem>() {
        override fun areItemsTheSame(
            oldItem: HeadLinesItem,
            newItem: HeadLinesItem
        ): Boolean {
            return oldItem.publishedAt == newItem.publishedAt
        }

        override fun areContentsTheSame(
            oldItem: HeadLinesItem,
            newItem: HeadLinesItem
        ): Boolean {
            return oldItem == newItem
        }
    }



}