package com.app.rajnikanthbookmyshow.ui.switchScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.rajnikanthbookmyshow.ui.contents.book.Book
import com.app.rajnikanthbookmyshow.ui.contents.bookSlot.BookSlot
import com.app.rajnikanthbookmyshow.ui.contents.chooseLocation.ChooseLocation
import com.app.rajnikanthbookmyshow.ui.contents.contact.Contact
import com.app.rajnikanthbookmyshow.ui.contents.home.Home
import com.app.rajnikanthbookmyshow.ui.contents.mySession.MySession
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
        composable(route = "Home") {
            Home(navController = navController, localDatabase = localDatabase)
        }
        composable(route = "Contact") {
            Contact(navController = navController)
        }
        composable(route = "ChooseLocation") {
            ChooseLocation(navController = navController)
        }
        composable(route = "MySession") {
            MySession(navController = navController)
        }
        composable(route = "Book"+"/{location}") {
            val location = it.arguments?.getString("location").toString()
            if(location!=null) {
                Book(navController = navController,location = location)
            }

        }
        composable(route = "BookSlot"+"/{image}"+"/{name}"+"/{label}"+"/{location}") {
            val image = it.arguments?.getString("image").toString().toInt()
            val name = it.arguments?.getString("name").toString()
            val label = it.arguments?.getString("label").toString()
            val location = it.arguments?.getString("location").toString()
            if(location!=null) {
                BookSlot(navController = navController, image = image,name = name, label = label,location = location)
            }

        }
    }

}