package com.appsv.cryptocurrencyapp.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsv.cryptocurrencyapp.common.Resource
import com.appsv.cryptocurrencyapp.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state : State<CoinListState> = _state

    init{
        getCoins()
    }

    private fun getCoins() {
        getCoinUseCase().onEach { result ->
           when(result){
               is Resource.Success ->{
                    _state.value = CoinListState(coins = result.data?: emptyList())
               }

               is Resource.Error -> {
                    _state.value = CoinListState(error = result.message ?: "An unexpected error occurred")
               }
               is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
               }
           }
        }
            .launchIn(viewModelScope)
    }
}