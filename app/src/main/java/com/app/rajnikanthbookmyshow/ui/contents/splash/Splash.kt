package com.app.rajnikanthbookmyshow.ui.contents.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.app.rajnikanthbookmyshow.R
import com.app.rajnikanthbookmyshow.ui.localDatabase.LocalDatabase
import com.app.rajnikanthbookmyshow.ui.theme.RajnikanthBookMyShowTheme
import com.app.rajnikanthbookmyshow.ui.theme.blue
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Splash(navController: NavController,localDatabase: LocalDatabase) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        delay(3.seconds)
        if(localDatabase.handle) {
            navController.navigate("SignIn") {
                popUpTo("Splash") {
                    inclusive = true
                }
            }
        }else{
            navController.navigate("SignIn") {
                popUpTo("Splash") {
                    inclusive = true
                }
            }
        }


    }
    RajnikanthBookMyShowTheme {
        Scaffold {
            Box(contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.ic_icon),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(blue)
                )
            }
        }
    }
}