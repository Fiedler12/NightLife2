package com.example.nightlife2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nightlife2.model.NavigationItem
import com.example.nightlife2.ui.theme.NightLife2Theme
import com.example.nightlife2.view.*
import com.example.nightlife2.viewmodel.HomeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NightLife2Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Screen(viewModel: HomeViewModel) {
    val navController = rememberNavController()
        Scaffold(
            bottomBar = { NavBar(navController = navController) }
        ) {
            NavigationGraph(navController = navController, viewModel)
        }
}

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

@Composable
fun NavBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Map,
        NavigationItem.Search,
        NavigationItem.Settings
    )
    BottomNavigation(
        Modifier.background(Color.LightGray),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach{item ->
            BottomNavigationItem(
                icon = { item.imageVector?.let { Icon(imageVector = it, contentDescription = item.title) } },
                label = { Text(text = item.title)},
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Black,
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let {route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    } })
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NightLife2Theme {
        Greeting("Android")
    }
}