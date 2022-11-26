package com.example.nightlife2.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun SearchPage() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Column(modifier = Modifier.fillMaxSize()) {
        TextField(modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = {newText ->
                text = newText
            },
            placeholder = { Text(text = "Search") })
        Text(text = "Maybe latest searches here?")
    }
}