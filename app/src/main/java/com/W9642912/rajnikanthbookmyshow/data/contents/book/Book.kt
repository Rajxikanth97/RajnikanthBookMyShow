package com.W9642912.rajnikanthbookmyshow.data.contents.book

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.W9642912.rajnikanthbookmyshow.R
import com.W9642912.rajnikanthbookmyshow.data.contents.dataModel.MoviesModel
import com.W9642912.rajnikanthbookmyshow.data.theme.RajnikanthBookMyShowTheme
import com.W9642912.rajnikanthbookmyshow.data.theme.blue
import com.W9642912.rajnikanthbookmyshow.data.theme.white

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Book(navController: NavController,location:String) {
    val context = LocalContext.current
    val list = arrayListOf<MoviesModel>().apply {
        clear()
       add(MoviesModel(image = R.drawable.ic_twister, name = "Twisters"))
       add(MoviesModel(image = R.drawable.ic_desplcable, name = "Desplcable Me 4"))
       add(MoviesModel(image = R.drawable.ic_inside, name = "Inside out 2"))
       add(MoviesModel(image = R.drawable.ic_fly,"Fly Me to the moon"))
       add(MoviesModel(image = R.drawable.ic_long,"Longlegs"))
       add(MoviesModel(image = R.drawable.ic_nun,"The nun"))
    }
    var movie by remember { mutableStateOf("") }

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
                            text = "List of movies", color = Color.White,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            style = TextStyle(fontWeight = FontWeight.Medium, fontSize = 16.sp)
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
                        Column(
                            modifier = Modifier.padding(8.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Text(
                                text = "Selected Theatre : ", color = Color.Black,
                                modifier = Modifier
                                    .fillMaxWidth(),
                                style = TextStyle(
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 16.sp
                                )
                            )
                            Text(
                                text = location, color = Color.Black,
                                modifier = Modifier
                                    .fillMaxWidth(),
                                style = TextStyle(
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 16.sp
                                )
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            list.forEach { model ->
                                Card(
                                    modifier = Modifier
                                        .padding(bottom = 20.dp, start = 10.dp, end = 10.dp)
                                        .background(color = white)
                                        .fillMaxWidth()
                                        .height(270.dp)
                                        .clickable {
                                            navController.navigate("BookSlot"+"/${model.image}"+"/${model.name}"+"/${model.label}"+"/${location}")
                                        },
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

                                }
                            }

                        }
                    }
                }
            }
        }


    }
}
