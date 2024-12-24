package com.example.portfolio.data

import com.example.portfolio.R

data class Project(
    val videoResourceId: Int,
    val title: String,
    val description: String,
    val libraries: String,
    val imageResourceId:Int
)

val projects = listOf(
    Project(
        videoResourceId = R.raw.notes,
        title = "Notes Application",
        description = "Add, Remove and Update your notes with just one click. Simple & super user friendly design.",
        libraries = "Jetpack Compose \n Room Database \n MVVM Architecture \n Hilt \n Firebase",
        imageResourceId = R.drawable.logo
    ),
    Project(
        videoResourceId = R.raw.notes,
        title = "Weather Forecast Application",
        description = "Forecast 7 days real-time weather information including temperature, wind speed, humidity and more.",
        libraries = "Jetpack Compose \n MVVM Architecture \n Hilt \n Retrofit ",
        imageResourceId = R.drawable.weather_logo
    ),
    Project(
        videoResourceId = R.raw.notes,
        title = "Trivia Contest Application",
        description = "A Trivia Application to test user's knowledge with trivia questions of different categories. Track user's progress as they progress.",
        libraries = "Jetpack Compose \n Hilt \n MVVM Architecture ",
        R.drawable.trivia
    )
)
