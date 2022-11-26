package com.example.nightlife2.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MapPage() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Map")
        // We should use google maps on this.
    }
}