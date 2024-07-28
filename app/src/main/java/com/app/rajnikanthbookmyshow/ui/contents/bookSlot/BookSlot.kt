package com.app.rajnikanthbookmyshow.ui.contents.bookSlot

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.app.rajnikanthbookmyshow.R
import com.app.rajnikanthbookmyshow.ui.appUtils.AppUtils
import com.app.rajnikanthbookmyshow.ui.applicationData.ApplicatonData.Companion.bookingList
import com.app.rajnikanthbookmyshow.ui.contents.dataModel.BookingModel
import com.app.rajnikanthbookmyshow.ui.contents.dataModel.MoviesModel
import com.app.rajnikanthbookmyshow.ui.theme.RajnikanthBookMyShowTheme
import com.app.rajnikanthbookmyshow.ui.theme.blue
import com.app.rajnikanthbookmyshow.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BookSlot(navController: NavController,image:Int,name:String,label:String,location:String) {
    val context = LocalContext.current
    val list = arrayListOf<String>().apply {
        clear()
        add("10 Am to 1 PM")
        add("1 PM to 4 PM")
        add("4 PM to 7 PM")
        add("7 PM to 10 PM")
    }
    var slot by remember { mutableStateOf("") }
    var confirm by remember { mutableStateOf(false) }
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
                            text = "Book Movie Slot", color = Color.White,
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
                        Text(
                            text = "Selected Theatre : ", color = Color.Black,
                            modifier = Modifier
                                .fillMaxWidth(),
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 18.sp
                            )
                        )
                        Text(
                            text = location, color = Color.Black,
                            modifier = Modifier
                                .fillMaxWidth(),
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 18.sp
                            )
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "Selected Movie : ", color = Color.Black,
                            modifier = Modifier
                                .fillMaxWidth(),
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 18.sp
                            )
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Card(
                            modifier = Modifier
                                .padding(start = 10.dp, end = 10.dp)
                                .background(color = white)
                                .fillMaxWidth()
                                .height(270.dp)
                                .clickable {

                                },
                            shape = RoundedCornerShape(10.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
                        ) {
                            Box(Modifier) {
                                Image(
                                    painter = painterResource(id = image),
                                    contentDescription = "Image",
                                    contentScale = ContentScale.FillBounds,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(200.dp)
                                )
                            }
                            Text(
                                name ?: "",
                                fontSize = 14.sp,
                                color = Color.Black,
                                modifier = Modifier
                                    .padding(vertical = 5.dp, horizontal = 10.dp)
                            )
                            Text(
                                label,
                                fontSize = 14.sp,
                                color = Color.Black,
                                modifier = Modifier
                                    .padding(vertical = 5.dp, horizontal = 10.dp)
                            )

                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Column(
                            modifier = Modifier.padding(8.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            list.forEach { name ->
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    RadioButton(
                                        selected = (name == slot),
                                        onClick = { slot = name }
                                    )
                                    Text(
                                        text = name,
                                        style = MaterialTheme.typography.bodyMedium,
                                        modifier = Modifier
                                            .padding(start = 8.dp)
                                            .clickable {
                                                slot = name
                                            }
                                    )
                                }
                            }

                        }
                        Box(Modifier.padding(15.dp)) {
                            Button(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp, end = 10.dp)
                                ,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = white
                                ),
                                contentPadding = PaddingValues(),
                                shape = RoundedCornerShape(10.dp),
                                onClick = {
                                    if(AppUtils.nullDataCheck(slot)) {
                                        Toast.makeText(context, "Please select slot.", Toast.LENGTH_SHORT).show()
                                    }else{
                                        bookingList.add(
                                            BookingModel(
                                                image, name, label, location, slot
                                            )
                                        )
                                        confirm = true
                                    }
                                },
                            ) {
                                Box(
                                    modifier = Modifier
                                        .background(blue)
                                        .then(
                                            Modifier
                                                .padding(vertical = 5.dp)
                                                .fillMaxWidth()
                                        ),
                                    contentAlignment = Alignment.Center,
                                ) {
                                    Text(
                                        text = "Submit",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        modifier = Modifier.padding(10.dp)
                                    )
                                }
                            }
                        }
                        Spacer(Modifier.height(10.dp))
                    }
                }
            }
        }

        if (confirm) {
            AlertDialog(
                onDismissRequest = {
                    confirm = false
                },
                title = { Text(stringResource(id = R.string.app_name)) },
                text = { Text("Your movie slot has been booked successfully.") },
                confirmButton = {
                    Button(
                        modifier = Modifier
                            .padding(vertical = 5.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.White
                        ),
                        contentPadding = PaddingValues(),
                        shape = RoundedCornerShape(30.dp),
                        onClick = {
                            navController.navigate("Home") {
                                popUpTo("BookSlot") {
                                    inclusive = true
                                }
                            }
                            confirm = false

                        },
                    ) {
                        Box(
                            modifier = Modifier
                                .background(blue)
                                .then(
                                    Modifier
                                        .padding(vertical = 5.dp)
                                        .fillMaxWidth()
                                ),
                            contentAlignment = Alignment.Center,
                        ) {
                            Text(
                                text = "Ok",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                    }
                },
                dismissButton = {}
            )
        }
    }
}
