package com.appsv.cryptocurrencyapp.domain.use_case.get_coin

import com.appsv.cryptocurrencyapp.common.Resource
import com.appsv.cryptocurrencyapp.data.remote.dto.toCoin
import com.appsv.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.appsv.cryptocurrencyapp.domain.model.Coin
import com.appsv.cryptocurrencyapp.domain.model.CoinDetail
import com.appsv.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(coinId : String) : Flow<Resource<CoinDetail>> = flow {
        try{
            emit(Resource.Loading<CoinDetail>()) // display the progress Bar

            val coins = repository.getCoinsById(coinId).toCoinDetail()

            emit(Resource.Success<CoinDetail>(coins))

        }
        catch (e: Exception){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))

        }
        catch (_: IOException){
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection"))
        }
    }
}