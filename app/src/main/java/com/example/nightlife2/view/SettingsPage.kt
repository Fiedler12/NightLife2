package com.example.nightlife2.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SettingsPage() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)) {
            Text(text = "Settings", modifier = Modifier.padding(5.dp), style = MaterialTheme.typography.h3)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        ) {
        }
        generateSettingsText(text = "Profile")
        generateSettingsText(text = "Preferences")
    }
}

@Composable
fun generateSettingsText(text: String) {
    Box(modifier = Modifier
        .height(50.dp)
        .fillMaxWidth()
        .border(4.dp, Color.DarkGray)) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start) {
            Text(
                text = text,
                modifier = Modifier.padding(2.dp),
                style = MaterialTheme.typography.h5
            )
        }
    }
}