package com.example.nightlife2.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nightlife2.viewmodel.BarViewModel
import com.example.nightlife2.viewmodel.SearchViewModel

@Composable
fun SearchPage(navController: NavController, searchViewModel: SearchViewModel) {
    var searchText by remember { mutableStateOf(TextFieldValue("")) }
    var bars = searchViewModel.barFlow
    Column(modifier = Modifier.fillMaxSize()) {
        TextField(modifier = Modifier.fillMaxWidth(),
            value = searchText,
            onValueChange = { newText ->
                searchText = newText
            },
            placeholder = { Text(text = "Search") })
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Button(onClick = { searchViewModel.fetchMatches(searchText.toString())
            bars = searchViewModel.barFlow
            }) {
                Text(text = "Search")
            }
        }
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(10.dp)) {
            items(bars) {item ->
                Text(text = item.name)
            }
        }
    }
}