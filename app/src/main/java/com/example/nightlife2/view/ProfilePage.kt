package com.example.nightlife2.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(id: Int?, navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
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
        Text(text = "Name",
            modifier = Modifier.padding(10.dp),
            style = MaterialTheme.typography.h3)
        Text(text = "Some log description",
            modifier = Modifier.padding(10.dp),
            style = MaterialTheme.typography.body1)
    }
}