package com.example.topheadlinesapp.ui.headlines

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.topheadlinesapp.data.model.local.HeadLinesItem
import com.example.topheadlinesapp.databinding.HeadlinesItemsBinding
import com.example.topheadlinesapp.utils.extensions.formatDate



class HeadLinesViewHolder(
    private val binding: HeadlinesItemsBinding,
    onItemClick: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.root.setOnClickListener {
            onItemClick(adapterPosition)
        }
    }

    fun bind(item: HeadLinesItem) {
        binding.title.text = item.title
        binding.date.text = item.date?.formatDate()
        Glide.with(binding.root)
            .load(item.imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .into(binding.image)

    }
}
