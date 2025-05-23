package com.appsv.cryptocurrencyapp.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsv.cryptocurrencyapp.domain.model.Coin

@Composable
fun CoinListItem(
    coin : Coin,
    onItemClick : (Coin) -> Unit ,
    ) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})" ,
            style = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            ),
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = if(coin.isActive) "active" else "inactive" ,
            color = if(coin.isActive) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic ,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            ),
            modifier = Modifier.align(CenterVertically)
        )

    }


}