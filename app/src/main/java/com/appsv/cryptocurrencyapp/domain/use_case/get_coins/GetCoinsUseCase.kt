package com.appsv.cryptocurrencyapp.domain.use_case.get_coins

import com.appsv.cryptocurrencyapp.common.Resource
import com.appsv.cryptocurrencyapp.data.remote.dto.toCoin
import com.appsv.cryptocurrencyapp.domain.model.Coin
import com.appsv.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try{
            emit(Resource.Loading<List<Coin>>()) // display the progress Bar

            val coins = repository.getCoins().map{ it.toCoin() }

            emit(Resource.Success<List<Coin>>(coins))

        }
        catch (e: Exception){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))

        }
        catch (_: IOException){
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection"))
        }
    }
}