package com.example.portfolio.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio.R


@Composable
fun PortfolioAbout(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = Color.Transparent
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                "About Me",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.SansSerif
                )
            )
//            Column(modifier = modifier.padding(10.dp)) {
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Surface(
                    modifier = modifier
                        .clip(shape = RoundedCornerShape(corner = CornerSize(5.dp))),
                    color = Color.Gray
                ) {
                    Column(modifier = modifier.padding(20.dp)) {
                        Text(
                            text = "Language:",
                            fontWeight = FontWeight.SemiBold, fontSize = 17.sp
                        )
                        Text(text = "English")
                        Text(text = "Marathi")
                        Text(text = "Hindi")
                        Text(text = "Kannada")
                    }
                }
                Surface(
                    modifier = modifier
                        .clip(shape = RoundedCornerShape(corner = CornerSize(5.dp))),
                    color = Color.Gray
                ) {
                    Column(modifier = modifier.padding(20.dp)) {
                        Text(
                            text = "Skills:",
                            fontWeight = FontWeight.SemiBold, fontSize = 17.sp
                        )
                        Text(text = "Java")
                        Text(text = "MySql")
                        Text(text = "Jetpack Compose")
                        Text(text = "Kotlin")
                    }
                }
            }
            Spacer(modifier = modifier.height(5.dp))
            Surface(
                modifier = modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(corner = CornerSize(5.dp))),
                color = Color.Gray
            ) {
                Column(modifier = modifier.padding(10.dp)) {
                    Text(
                        text = "Internship", style =
                        TextStyle(
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "1. Nimap Technology",
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(text = "Conducted thorough testing and debugging to ensure optimal performance and seamless experience with zero functionality errors")
                    Text(
                        text = "2. Insys Technology",
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(text = "Developed an online booking platform for scheduling turf reservations using HTML, CSS, Javascript for front-end design and functionality")
                }
            }
        }
    }
    //}
}

@Composable
fun Content(
    drawable: Int,
    projectTitle: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = "Project Image",
                modifier = modifier
                    .clip(shape = CircleShape)
                    .size(80.dp),
                contentScale = ContentScale.Crop
            )
            Text(projectTitle)
        }
    }
}

@Composable
fun PortfolioName(
    name: String,
    style: TextStyle,
) {
    Text(
        text = name,
        style = style
    )
}

@Composable
fun PortfolioButton(onClickState: () -> Unit) {
    Button(
        shape = RoundedCornerShape(corner = CornerSize(5.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
        border = BorderStroke(width = 1.dp, color = Color.Black),
        onClick = {
            onClickState()
        }
    ) {
        Text(
            text = "Portfolio",
            color = Color.Black,
            fontSize = 15.sp
        )
    }
}

@Composable
fun ImageProfile(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.profile_photo),
        contentDescription = "Portfolio Photo",
        modifier = modifier
            .size(170.dp)
            .clip(RoundedCornerShape(corner = CornerSize(100.dp))),
        contentScale = ContentScale.Crop
    )
}