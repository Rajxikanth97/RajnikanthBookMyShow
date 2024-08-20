package com.W9642912.rajnikanthbookmyshow.data.contents.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.W9642912.rajnikanthbookmyshow.R
import com.W9642912.rajnikanthbookmyshow.data.localDatabase.LocalDatabase
import com.W9642912.rajnikanthbookmyshow.data.theme.RajnikanthBookMyShowTheme
import com.W9642912.rajnikanthbookmyshow.data.theme.blue
import com.W9642912.rajnikanthbookmyshow.data.topToolBar.TopToolBar
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Splash(navController: NavController, localDatabase: LocalDatabase) {
    LaunchedEffect(Unit) {
        delay(3.seconds)
        if (localDatabase.handle) {
            navController.navigate("Home") {
                popUpTo("Splash") {
                    inclusive = true
                }
            }
        } else {
            navController.navigate("SignIn") {
                popUpTo("Splash") {
                    inclusive = true
                }
            }
        }


    }
    RajnikanthBookMyShowTheme {
        Scaffold {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = blue)
            ) {
                TopToolBar {

                }
                Box(contentAlignment = Alignment.Center) {
                    Image(
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(blue),
                        painter = painterResource(id = R.drawable.ic_icon),
                    )
                }
            }
        }
    }
}