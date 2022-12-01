package com.example.nightlife2.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nightlife2.repositories.Review

@Composable
fun ReviewComponent(review: Review) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color.LightGray)
            .padding()
            .border(1.dp, color = Color.Black)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = review.rating.toString(),
                modifier = Modifier.padding(10.dp),
                style = MaterialTheme.typography.body2)
            Text(text = review.review,
                modifier = Modifier.padding(10.dp),
                style = MaterialTheme.typography.body1)
        }
    }
}

@Preview
@Composable
fun componentPreview() {
    val test = Review(1, 2, "Test", 4.2)
    ReviewComponent(review = test)
}