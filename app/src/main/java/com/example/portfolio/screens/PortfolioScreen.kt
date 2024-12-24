package com.example.portfolio.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.portfolio.R
import com.example.portfolio.components.Content
import com.example.portfolio.components.ImageProfile
import com.example.portfolio.components.PortfolioAbout
import com.example.portfolio.components.PortfolioButton
import com.example.portfolio.components.PortfolioName
import com.example.portfolio.data.Project
import com.example.portfolio.data.projects

@Composable
fun PortfolioScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val portfolioButton = remember {
        mutableStateOf(false)
    }
//    val contentItem = listOf(
//        R.drawable.logo to "Notes Application",
//        R.drawable.weather_logo to "Weather Forecast Application",
//        R.drawable.trivia to "Contest Trivia Application"
//    )
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        Card(
            modifier = modifier
                .fillMaxSize()
                .padding(10.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.elevatedCardElevation(7.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp))
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ImageProfile(modifier)
                Spacer(modifier = modifier.height(15.dp))
                PortfolioName(
                    "Rahul Durvas", style = TextStyle(
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif
                    )
                )
                Spacer(modifier = modifier.height(15.dp))
                PortfolioButton {
                    portfolioButton.value = !portfolioButton.value
                }
                Spacer(modifier = modifier.height(15.dp))
                if (portfolioButton.value) {
                    CardContent(projects = projects, onProjectClick = { project ->
                        navController.navigate("projectDetail/${project.title}")
                    })
                } else {
                    Box {
                        PortfolioAbout()
                    }
                }
            }
        }
    }
}


@Composable
fun CardContent(
//    items: List<Pair<Int, String>>,
    projects: List<Project>,
    onProjectClick: (Project) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(corner = CornerSize(5.dp))),
        color = Color.LightGray
    ) {
        LazyColumn(modifier = modifier.padding(top = 5.dp)) {
            items(projects) { project ->
                Content(
                    drawable = project.imageResourceId,
                    projectTitle = project.title,
                    modifier = modifier.clickable { onProjectClick(project) }
                )
            }
        }
    }
}
