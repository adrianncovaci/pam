package com.example.lab2.api

data class CoinDetails(
    val coingecko_rank: Int,
    val coingecko_score: Double,
    val community_score: Double,
    val country_origin: String,
    val current_price: CurrentPrice,
    val developer_score: Double,
    val hashing_algorithm: String,
    val id: String,
    val liquidity_score: Int,
    val market_cap_rank: Int,
    val name: String,
    val public_interest_score: Double,
    val symbol: String
)