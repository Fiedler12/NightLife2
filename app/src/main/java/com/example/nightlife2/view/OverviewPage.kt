package com.example.nightlife2.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.example.nightlife2.viewmodel.HomeViewModel

@Composable
fun OverviewPage(viewModel: HomeViewModel, navController: NavController) {
    val bars by viewModel.barState.collectAsState()
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome to NightLife!",
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.h3)
        Text (text = "Your favorites",
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.h5)
        LazyRow(modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .padding(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            items(bars) {
                FavoriteComponent(it) {
                    navController.navigate("bar/" + it.id)
                    NavOptions.Builder()
                        .setPopUpTo("home", inclusive = true)
                        .build()
                }
            }
        }
        Text(text = "Trending in Copenhagen",
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.h5)
        LazyRow(modifier = Modifier
            .height(250.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            items(bars) {
                TrendyComponent(it) {
                    navController.navigate("bar/" + it.id)
                    NavOptions.Builder()
                        .setPopUpTo("home", inclusive = true)
                        .build()
                }
            }
        }
        Text(text = "Closest to you",
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.h5)
        LazyRow(modifier = Modifier
            .height(250.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            items(bars) {
                ProximityComponent(it) {
                    navController.navigate("bar/" + it.id)
                    NavOptions.Builder()
                        .setPopUpTo("home", inclusive = true)
                        .build()
                }
            }
        }
    }
}