package com.example.lab2.presentation.feed.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.databinding.FeedCellLayoutBinding
import com.example.lab2.presentation.feed.models.FeedItem


class FeedItemViewHolder(private val binding: FeedCellLayoutBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: FeedItem) {
        binding.headerTextView.text = item.header
        binding.nameTextView.text = item.name
        binding.symbolTextView.text = item.symbol

    }
}