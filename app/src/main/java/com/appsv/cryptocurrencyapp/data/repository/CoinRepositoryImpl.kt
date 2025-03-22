package com.appsv.cryptocurrencyapp.data.repository

import com.appsv.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.appsv.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.appsv.cryptocurrencyapp.data.remote.dto.CoinDto
import com.appsv.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api : CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinsById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}