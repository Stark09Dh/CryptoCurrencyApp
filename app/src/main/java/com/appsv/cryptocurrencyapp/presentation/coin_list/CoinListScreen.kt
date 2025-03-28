package com.appsv.cryptocurrencyapp.presentation.coin_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.appsv.cryptocurrencyapp.presentation.Screen
import com.appsv.cryptocurrencyapp.presentation.coin_list.components.CoinListItem
import dagger.multibindings.LazyClassKey

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.coins) { coin ->
                CoinListItem(
                    coin = coin,
                    onItemClick = {
                        navController.navigate(Screen.CoinDetailScreen.route + "/${coin.id}" )
                    }
                )

            }
        }
        if(state.error.isNotBlank()){
            Text(
                text = state.error ,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp).align(Alignment.Center)
            )
        }

        if(state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
    
}