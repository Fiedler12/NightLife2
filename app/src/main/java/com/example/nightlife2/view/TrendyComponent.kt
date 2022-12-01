package com.example.nightlife2.view

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.nightlife2.repositories.Bar

@Composable
fun TrendyComponent(bar: Bar, onButtonClick: () -> Unit) {
    val configuration = LocalConfiguration.current
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
        Box(modifier = Modifier
            .height(250.dp)
            .width(configuration.screenWidthDp.dp - 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.LightGray)
            .clickable { onButtonClick() }) {
            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = bar.name,
                    modifier = Modifier
                        .padding(10.dp),
                    style = MaterialTheme.typography.h3
                )
                Text(
                    text = "Rating: " + bar.rating.toString(),
                    modifier = Modifier
                        .padding(5.dp)
                        .alpha(0.8f),
                    style = MaterialTheme.typography.body2
                )
                Text(
                    text = "Address or some shit",
                    modifier = Modifier
                        .padding(10.dp)
                        .alpha(0.8f),
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = bar.description,
                    modifier = Modifier.padding(10.dp),
                    style = MaterialTheme.typography.caption
                )

            }
        }
    }
}