package com.app.rajnikanthbookmyshow.ui.switchScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.rajnikanthbookmyshow.ui.contents.signIn.SignIn
import com.app.rajnikanthbookmyshow.ui.contents.signUp.Signup
import com.app.rajnikanthbookmyshow.ui.contents.splash.Splash
import com.app.rajnikanthbookmyshow.ui.localDatabase.LocalDatabase

@Composable
fun SwitchScreen() {
    val context = LocalContext.current
    val navController = rememberNavController()
    val localDatabase = LocalDatabase(context)
    NavHost(
        navController = navController,
        startDestination = "Splash"
    ) {
        composable(route = "Splash") {
            Splash(navController = navController, localDatabase = localDatabase)
        }
        composable(route = "SignIn") {
            SignIn(navController = navController, localDatabase = localDatabase)
        }
        composable(route = "Signup") {
            Signup(navController = navController, localDatabase = localDatabase)
        }

    }

}