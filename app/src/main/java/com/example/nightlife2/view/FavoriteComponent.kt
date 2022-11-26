package com.example.nightlife2.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.nightlife2.model.Bar

@Composable
fun FavoriteComponent(bar: Bar, onButtonClick: () -> Unit) {
    Box(modifier = Modifier
        .height(100.dp)
        .width(200.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(Color.LightGray)
        .padding()
        .clickable { onButtonClick() }){
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = bar.name,
                    modifier = Modifier.padding(5.dp),
                    style = MaterialTheme.typography.h4
                )
                Text(
                    text = bar.rating.toString(),
                    modifier = Modifier
                        .padding(horizontal = 5.dp, vertical = 10.dp)
                        .alpha(0.5f),
                    style = MaterialTheme.typography.h5
                )
            }
            Text(
                text = "Open",
                modifier = Modifier
                    .padding(5.dp)
                    .alpha(0.5f),
                style = MaterialTheme.typography.h6
            )
        }
    }
    // Should be clickable to navigate to company profile.
}