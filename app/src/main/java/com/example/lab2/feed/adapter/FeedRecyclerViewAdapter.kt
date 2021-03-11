package com.example.lab2.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.databinding.FeedCellLayoutBinding
import com.example.lab2.feed.models.FeedItem
import com.example.lab2.feed.viewHolder.FeedItemViewHolder

class FeedRecyclerViewAdapter(private var data: Array<FeedItem>):
    RecyclerView.Adapter<FeedItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedItemViewHolder {
        val binding = FeedCellLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FeedItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    fun updateDataSet(dataSet: Array<FeedItem>) {
        this.data = dataSet
        notifyDataSetChanged()
    }
}