package com.example.portfolio.screens

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.portfolio.data.Project
import com.example.portfolio.data.projects

@Composable
fun VideoPlayer(
    videoResourceId: Int,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            val videoUri =
                Uri.parse("android.resource://${context.packageName}/$videoResourceId")
            val mediaItem = MediaItem.fromUri(videoUri)
            setMediaItem(mediaItem)
            prepare()
            playWhenReady = true
        }
    }
    AndroidView(
        factory = {
            PlayerView(context).apply {
                player = exoPlayer
                useController = false
            }
        },
        modifier = modifier.fillMaxWidth()
    )
    DisposableEffect(
        Unit
    ) {
        onDispose {
            exoPlayer.release()
        }
    }
}

@Composable
fun ProjectScreen(
//    project: Project,
    projectTitle: String, //   videoResourceId: Int,
    modifier: Modifier = Modifier
) {

    val project = projects.find { it.title == projectTitle }

    project?.let {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            VideoPlayer(videoResourceId = project.videoResourceId)
            Text(
                text = project.title,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace

                ),
                modifier = modifier.padding(15.dp)
            )
            Text(
                text = project.description,
                style = TextStyle(
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Default
                ), modifier = modifier.padding(start = 15.dp)
            )
            Text(
                text = "Frameworks & Libraries:",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Default
                ), modifier = modifier.padding(15.dp)
            )
            Text(
                text = project.libraries,
                style = TextStyle(
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Default
                ), modifier = modifier.padding(start = 15.dp)
            )

        }

    } ?: run {
        Text(text = "Project not found")
    }
}
