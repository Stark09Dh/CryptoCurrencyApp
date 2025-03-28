package com.appsv.cryptocurrencyapp.domain.repository

import com.appsv.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.appsv.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinsById (coinId : String) : CoinDetailDto

}