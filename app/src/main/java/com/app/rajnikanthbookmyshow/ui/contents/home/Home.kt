package com.app.rajnikanthbookmyshow.ui.contents.home

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.rajnikanthbookmyshow.R
import com.app.rajnikanthbookmyshow.ui.appUtils.AppUtils
import com.app.rajnikanthbookmyshow.ui.headerTopBar.HeaderTopBar
import com.app.rajnikanthbookmyshow.ui.localDatabase.LocalDatabase
import com.app.rajnikanthbookmyshow.ui.theme.RajnikanthBookMyShowTheme
import com.app.rajnikanthbookmyshow.ui.theme.blue
import com.app.rajnikanthbookmyshow.ui.theme.white
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(navController: NavController, localDatabase: LocalDatabase) {
    val context = LocalContext.current
    val nestedScroll = rememberScrollState()
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    var signOut by remember { mutableStateOf(false) }
    val list = arrayListOf<String>().apply {
        clear()
        add("Liverpool\n" +
                "340 East Lancashire Road, Norris Green\n" +
                "Liverpool, England L11 9YJ\n" +
                "01515492044")
        add("Teesside\n" +
                "Aintree Oval Teesside Leisure Park\n" +
                "Stockton-on-Tees, England TS17 7BU\n" +
                "01642633111")
        add("Nottingham\n" +
                "Redfield Way Lenton\n" +
                "Nottingham, England NG7 2UW\n" +
                "01159862505")
        add("Coventry\n" +
                "Gielgud Way, Walsgrave\n" +
                "Coventry, England CV2 2SZ\n" +
                "02476602555")
    }
    var location by remember { mutableStateOf("") }


    RajnikanthBookMyShowTheme {
        androidx.compose.material.Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                HeaderTopBar(
                    navController = navController,
                    onButtonClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }
                )
            },
            modifier = Modifier.background(color = blue),
            drawerContent = {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(color = blue)
                        .fillMaxWidth()
                ) {

                    Image(
                        painterResource(id = R.drawable.ic_icon),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .height(150.dp)

                    )
                    Spacer(modifier = Modifier)

                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 10.dp)
                        .background(color = white)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                scope.launch {
                                    scaffoldState.drawerState.close()
                                }

                            }
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Spacer(modifier = Modifier.width(16.dp))
                        androidx.compose.material.Text(text = "Home", color = Color.Black)
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                scope.launch {
                                    scaffoldState.drawerState.close()
                                }
                                navController.navigate("Contact")
                            }
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Spacer(modifier = Modifier.width(16.dp))
                        androidx.compose.material.Text(text = "About Us", color = Color.Black)
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                scope.launch {
                                    scaffoldState.drawerState.close()
                                }
                                navController.navigate("ChooseLocation")
                            }
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Spacer(modifier = Modifier.width(16.dp))
                        androidx.compose.material.Text(text = "Choose Location", color = Color.Black)
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                scope.launch {
                                    scaffoldState.drawerState.close()
                                }
                                navController.navigate("MySession")
                            }
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Spacer(modifier = Modifier.width(16.dp))
                        androidx.compose.material.Text(text = "My Session", color = Color.Black)
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                scope.launch {
                                    scaffoldState.drawerState.close()
                                }
                                signOut = true
                            }
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Spacer(modifier = Modifier.width(16.dp))
                        androidx.compose.material.Text(text = "Sign out", color = Color.Black)
                    }

                }
            },
            backgroundColor = blue,
            contentColor = blue,
            drawerBackgroundColor = blue
        ) { paddingValues ->
            Modifier.padding(
                bottom = paddingValues.calculateBottomPadding()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = white)
                    .verticalScroll(nestedScroll)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Select Theatre : ", color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                )
                Column(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    list.forEach { name ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = (name == location),
                                onClick = { location = name }
                            )
                            Text(
                                text = name,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier
                                    .padding(start = 8.dp)
                                    .clickable {
                                        location = name
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
                            if(AppUtils.nullDataCheck(location)) {
                                Toast.makeText(context, "Please select theatre.", Toast.LENGTH_SHORT).show()
                            }else{
                                navController.navigate("Book"+"/${location}")
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
        if (signOut) {
            AlertDialog(
                onDismissRequest = {
                    signOut = false
                },
                title = { Text(stringResource(id = R.string.app_name)) },
                text = { Text("Are you sure you want to sign out ?") },
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
                            signOut = false
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
                                text = "Cancel",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                    }
                },
                dismissButton = {
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
                            localDatabase.handle = false
                            navController.navigate(
                                "SignIn"
                            ) {
                                popUpTo("Home") {
                                    inclusive = true
                                }
                            }
                            signOut = false
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
                                text = "Sign out",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                    }

                }
            )
        }
    }
}







