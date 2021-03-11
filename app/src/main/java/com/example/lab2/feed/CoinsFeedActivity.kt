package com.example.lab2.feed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.R
import com.example.lab2.api.ApiRequests
import com.example.lab2.api.CoinsApi
import com.example.lab2.databinding.ActivityCoinsFeedBinding
import com.example.lab2.feed.adapter.FeedRecyclerViewAdapter
import com.example.lab2.feed.models.FeedItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.coingecko.com/api/v3/"

class CoinsFeedActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: FeedRecyclerViewAdapter
    private lateinit var binding: ActivityCoinsFeedBinding
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var progressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinsFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        progressBar = findViewById(R.id.progressBar)
        viewManager = LinearLayoutManager (this)
        viewAdapter = FeedRecyclerViewAdapter(emptyArray())
        recyclerView = binding.feedRecyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        getCurrentData()
    }

    private fun getCurrentData() {
        progressBar.visibility = View.VISIBLE
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRequests::class.java)

        GlobalScope.launch(Dispatchers.IO) {

            val response = api.getCoinsList().awaitResponse()
            if (response.isSuccessful) {

                val dataset = handleData(response.body())

                withContext(Dispatchers.Main) {
                    progressBar.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE
                    if (dataset != null) {
                        viewAdapter.updateDataSet(dataset)
                    }
                }
            }
        }
    }

    private fun handleData(data: ArrayList<CoinsApi>?): Array<FeedItem>? {
        val dataSet = data?.map {
            FeedItem(it.id, it.name, it.symbol)
        }?.toTypedArray()
        return dataSet
    }
}