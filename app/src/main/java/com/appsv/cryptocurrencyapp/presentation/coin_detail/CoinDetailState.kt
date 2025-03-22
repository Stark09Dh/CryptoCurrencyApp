package com.appsv.cryptocurrencyapp.presentation.coin_detail

import com.appsv.cryptocurrencyapp.domain.model.Coin
import com.appsv.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading : Boolean = false ,
    val coin : CoinDetail ? = null,
    val error : String = ""
)
