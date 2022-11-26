package com.example.nightlife2.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.nightlife2.model.NavigationItem
import com.example.nightlife2.viewmodel.HomeViewModel


/*
@Composable
fun NavigationGraph(navController: NavHostController, viewModel: HomeViewModel) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            OverviewPage(viewModel = viewModel, navController)
        }
        composable(NavigationItem.Map.route) {
            MapPage()
        }
        composable(NavigationItem.Search.route) {
            SearchPage()
        }
        composable(NavigationItem.Settings.route) {
            SettingsPage()
        }
        composable(
            NavigationItem.Bar.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            ProfileScreen(id = it.arguments?.getInt("id"), navController)
        }

    }
}

 */