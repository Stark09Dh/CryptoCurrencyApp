package com.appsv.cryptocurrencyapp.presentation.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsv.cryptocurrencyapp.data.remote.dto.TeamMember

@Composable
fun TeamListItem(
    teamMember: TeamMember ,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = teamMember.name ,
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )
        )

        Text(
            text = teamMember.position,
            fontStyle = FontStyle.Italic,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider(
            thickness = 1.dp,
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.height(16.dp))


    }

}