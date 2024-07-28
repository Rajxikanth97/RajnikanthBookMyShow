package com.app.rajnikanthbookmyshow.ui.contents.chooseLocation

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.rajnikanthbookmyshow.ui.theme.RajnikanthBookMyShowTheme
import com.app.rajnikanthbookmyshow.ui.theme.blue
import com.app.rajnikanthbookmyshow.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ChooseLocation(navController: NavController) {
    val context = LocalContext.current

    RajnikanthBookMyShowTheme {
        Scaffold {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = blue)
            ) {
                SmallTopAppBar(
                    title = {
                        Text(
                            text = "Choose Location", color = Color.White,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navController.navigateUp()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.ArrowBack,
                                tint = Color.White,
                                contentDescription = "Back"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = blue,
                        titleContentColor = Color.White
                    )
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = white)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "⦁ Liverpool",
                            color = Color.Black,
                            modifier = Modifier
                                .fillMaxWidth(),
                            style = TextStyle(fontWeight = FontWeight.Normal, fontSize = 18.sp)
                        )
                        Text(
                            text = "⦁ Teesside",
                            color = Color.Black,
                            modifier = Modifier
                                .fillMaxWidth(),
                            style = TextStyle(fontWeight = FontWeight.Normal, fontSize = 18.sp)
                        )
                        Text(
                            text = "⦁ Nottingham",
                            color = Color.Black,
                            modifier = Modifier
                                .fillMaxWidth(),
                            style = TextStyle(fontWeight = FontWeight.Normal, fontSize = 18.sp)
                        )
                        Text(
                            text = "⦁ Coventry",
                            color = Color.Black,
                            modifier = Modifier
                                .fillMaxWidth(),
                            style = TextStyle(fontWeight = FontWeight.Normal, fontSize = 18.sp)
                        )
                    }

                }
            }
        }


    }
}
