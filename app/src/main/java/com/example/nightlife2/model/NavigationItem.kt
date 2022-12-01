package com.example.nightlife2.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(var route: String, var title: String, var imageVector: ImageVector?) {
    object Home : NavigationItem("Home", "Home", Icons.Filled.Home)
    object Search: NavigationItem("Search", "Search", Icons.Filled.Search)
    object Settings : NavigationItem("movies", "Settings", Icons.Filled.Settings)
    object Bar : NavigationItem("bar/{id}", "BarProfile", null)
}