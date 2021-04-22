package com.example.lab2.presentation.feed.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.databinding.FeedCellLayoutBinding
import com.example.lab2.presentation.detailView.DetailsActivity
import com.example.lab2.presentation.feed.models.FeedItem
import com.example.lab2.presentation.feed.viewHolder.FeedItemViewHolder

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
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
            intent.putExtra("id", data[position].header)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = data.size

    fun updateDataSet(dataSet: Array<FeedItem>) {
        this.data = dataSet
        notifyDataSetChanged()
    }
}