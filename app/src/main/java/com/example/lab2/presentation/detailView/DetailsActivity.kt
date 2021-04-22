package com.example.lab2.presentation.detailView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.lab2.R
import com.example.lab2.databinding.ActivityDetailsBinding
import com.example.lab2.presentation.detailView.tabs.adapters.ViewPagerAdapter

class DetailsActivity : AppCompatActivity() {
    lateinit var text1: TextView
    private lateinit var binding: ActivityDetailsBinding
    private val pagerAdapter = ViewPagerAdapter(this.supportFragmentManager)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = pagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        text1 = findViewById<TextView>(R.id.id)

        if (intent.hasExtra("id")) {
            text1.text = intent.getStringExtra("id")
        }
    }
}