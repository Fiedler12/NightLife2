package com.example.nightlife2.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nightlife2.repositories.Bar
import com.example.nightlife2.viewmodel.BarViewModel

@Composable
fun ProfileScreen(id: Int, navController: NavController, barViewModel: BarViewModel) {
    barViewModel.fetchBar(id)
    barViewModel.fetchReviews(id)
    val bar = barViewModel.barFlow
    val reviews = barViewModel.reviewFlow
    Column(modifier = Modifier.fillMaxWidth()) {
        Button(onClick = { navController.popBackStack() }) {
            Text("<---")
        }
        Box(
            Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.LightGray)) {
            Text(text = "$id")
        }
        Text(text = bar.name,
            modifier = Modifier.padding(10.dp),
            style = MaterialTheme.typography.h3)
        Text(text = bar.rating.toString(),
            modifier = Modifier.padding(10.dp),
            style = MaterialTheme.typography.body1)
        Text(text = bar.description, modifier = Modifier.padding(10.dp), style = MaterialTheme.typography.body1)
        Text(text = "Reviews", modifier = Modifier.padding(10.dp), style = MaterialTheme.typography.h5)
        LazyColumn(
            Modifier
                .height(300.dp)
                .fillMaxWidth()
                .padding(10.dp)) {
            items(reviews) {item ->
                ReviewComponent(review = item)
            }

        }
    }
}