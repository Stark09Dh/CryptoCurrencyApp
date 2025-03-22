package com.appsv.cryptocurrencyapp.presentation.coin_list

import com.appsv.cryptocurrencyapp.domain.model.Coin

data class CoinListState(
    val isLoading : Boolean = false ,
    val coins : List<Coin> = emptyList(),
    val error : String = ""
) {

}
