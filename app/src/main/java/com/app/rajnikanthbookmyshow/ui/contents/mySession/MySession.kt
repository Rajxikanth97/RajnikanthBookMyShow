package com.app.rajnikanthbookmyshow.ui.contents.mySession

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.rajnikanthbookmyshow.ui.applicationData.ApplicatonData
import com.app.rajnikanthbookmyshow.ui.theme.RajnikanthBookMyShowTheme
import com.app.rajnikanthbookmyshow.ui.theme.blue
import com.app.rajnikanthbookmyshow.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MySession(navController: NavController) {
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
                            text = "My Session", color = Color.White,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            style = TextStyle(fontWeight = FontWeight.Medium, fontSize = 18.sp)
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
                        .verticalScroll(rememberScrollState())
                        .background(color = white)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)
                    ) {
                        if (ApplicatonData.bookingList.size > 0) {
                            Column(
                                modifier = Modifier.padding(8.dp),
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {

                                ApplicatonData.bookingList.forEach { model ->
                                    Card(
                                        modifier = Modifier
                                            .padding(bottom = 20.dp)
                                            .background(color = white)
                                            .fillMaxWidth()
                                            .height(380.dp),
                                        shape = RoundedCornerShape(10.dp),
                                        colors = CardDefaults.cardColors(containerColor = Color.White),
                                        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
                                    ) {
                                        Box(Modifier) {
                                            Image(
                                                painter = painterResource(id = model.image),
                                                contentDescription = "Image",
                                                contentScale = ContentScale.FillBounds,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(200.dp)
                                            )
                                        }
                                        Text(
                                            model.name ?: "",
                                            fontSize = 14.sp,
                                            color = Color.Black,
                                            modifier = Modifier
                                                .padding(vertical = 5.dp, horizontal = 10.dp)
                                        )

                                        Text(
                                            model.label,
                                            fontSize = 14.sp,
                                            color = Color.Black,
                                            modifier = Modifier
                                                .padding(vertical = 5.dp, horizontal = 10.dp)
                                        )
                                        Text(
                                            "Location : ",
                                            fontSize = 14.sp,
                                            color = Color.Black,
                                            modifier = Modifier
                                                .padding(vertical = 5.dp, horizontal = 10.dp)
                                        )
                                        Text(
                                            model.location,
                                            fontSize = 14.sp,
                                            color = Color.Black,
                                            modifier = Modifier
                                                .padding(vertical = 5.dp, horizontal = 10.dp)
                                        )
                                        Text(
                                            "Slot : ",
                                            fontSize = 14.sp,
                                            color = Color.Black,
                                            modifier = Modifier
                                                .padding(vertical = 5.dp, horizontal = 10.dp)
                                        )
                                        Text(
                                            model.slot,
                                            fontSize = 14.sp,
                                            color = Color.Black,
                                            modifier = Modifier
                                                .padding(vertical = 5.dp, horizontal = 10.dp)
                                        )
                                    }
                                }

                            }
                        } else {
                            Text(
                                text = "No Booking Found.", color = Color.Black,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(10.dp),
                                style = TextStyle(fontWeight = FontWeight.Normal, fontSize = 18.sp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }


    }
}
