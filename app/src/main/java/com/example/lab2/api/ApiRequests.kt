package com.example.lab2.api

import com.example.lab2.api.models.CoinDetails
import com.example.lab2.api.models.CoinsApi
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query


interface ApiRequests {
    @GET("coins/list")
    fun getCoinsList(): Call<ArrayList<CoinsApi>>
    @GET("coins/")
    fun getCoinsList(@Query("id") id: String): Call<CoinDetails>
}