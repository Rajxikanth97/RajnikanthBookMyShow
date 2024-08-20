package com.W9642912.rajnikanthbookmyshow.data.contents.chooseLocation

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
import com.W9642912.rajnikanthbookmyshow.data.theme.RajnikanthBookMyShowTheme
import com.W9642912.rajnikanthbookmyshow.data.theme.blue
import com.W9642912.rajnikanthbookmyshow.data.theme.white

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ChooseLocation(navController: NavController) {
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
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            text = "Choose Location", color = Color.White,
                            style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
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
                            .padding(8.dp)
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            style = TextStyle(fontWeight = FontWeight.Light, fontSize = 16.sp),
                            text = "⦁ Liverpool",
                            color = Color.Black
                        )
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            style = TextStyle(fontWeight = FontWeight.Light, fontSize = 16.sp),
                            text = "⦁ Teesside",
                            color = Color.Black,
                        )
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            style = TextStyle(fontWeight = FontWeight.Light, fontSize = 16.sp),
                            text = "⦁ Nottingham",
                            color = Color.Black
                        )
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            style = TextStyle(fontWeight = FontWeight.Light, fontSize = 16.sp),
                            text = "⦁ Coventry",
                            color = Color.Black
                        )
                    }

                }
            }
        }


    }
}
