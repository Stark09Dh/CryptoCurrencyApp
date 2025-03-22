package com.appsv.cryptocurrencyapp.data.remote.dto

import com.appsv.cryptocurrencyapp.domain.model.Coin
import com.google.gson.annotations.SerializedName


data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)


// function to map CoinDto to Coin -- > means how Coin data class gets it's value from CoinDto
fun CoinDto.toCoin() : Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}