package com.example.portfolio.navigation

sealed class PortfolioScreens(val route:String){
    object MAIN_SCREEN :PortfolioScreens("main_screen")
    object PROJECT_SCREEN : PortfolioScreens("project_screen")
}