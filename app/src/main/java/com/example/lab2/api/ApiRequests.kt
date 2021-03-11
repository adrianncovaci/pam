package com.example.lab2.api

import com.example.lab2.api.CoinsApi
import retrofit2.http.GET
import retrofit2.Call


interface ApiRequests {
    @GET("coins/list")
    fun getCoinsList(): Call<ArrayList<CoinsApi>>
}