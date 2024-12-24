package com.example.portfolio.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.portfolio.screens.PortfolioScreen
import com.example.portfolio.screens.ProjectScreen

@Composable
fun PortfolioNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = PortfolioScreens.MAIN_SCREEN.route
    ) {
        composable(route = PortfolioScreens.MAIN_SCREEN.route) {
            PortfolioScreen(navController)
        }
        composable("projectDetail/{projectTitle}"){ navBackStackEntry ->
            val projectTitle = navBackStackEntry.arguments?.getString("projectTitle")?:""
            ProjectScreen(
                projectTitle = projectTitle,
            )
        }
    }
}