package com.app.rajnikanthbookmyshow.ui.contents.signUp

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.app.rajnikanthbookmyshow.R
import com.app.rajnikanthbookmyshow.ui.localDatabase.LocalDatabase
import com.app.rajnikanthbookmyshow.ui.theme.RajnikanthBookMyShowTheme
import com.app.rajnikanthbookmyshow.ui.theme.blue
import com.app.rajnikanthbookmyshow.ui.theme.white


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Signup(navController: NavController,localDatabase: LocalDatabase) {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val scrollState = rememberScrollState()



    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var scroller by remember { mutableStateOf(false) }


    val customBottomShape = GenericShape { size, _ ->
        val width = size.width
        val height = size.height

        moveTo(0f, height / 2)
        cubicTo(width / 2, 0f, width / 2, 0f, width, height / 2)
        lineTo(width, height)
        lineTo(0f, height)
        close()
    }
    RajnikanthBookMyShowTheme {
        Scaffold {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .background(blue)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(white)
                        .padding(15.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(containerColor = blue),
                        elevation = CardDefaults.cardElevation(5.dp),
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                        ) {
                            Spacer(modifier = Modifier.height(20.dp))
                            Image(
                                painter = painterResource(id = R.drawable.ic_icon),
                                contentDescription = "",
                                contentScale = ContentScale.FillWidth,
                                modifier = Modifier.fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(20.dp))
                            Text(
                                "Sign Up",
                                modifier = Modifier.fillMaxWidth(),
                                style = TextStyle(color = white, fontSize = 16.sp),
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            Text(
                                "Name",
                                modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
                                style = TextStyle(color = white)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            TextField(
                                value = name,
                                onValueChange = { name = it },
                                label = { Text("Enter name") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp, end = 10.dp)
                                    .background(Color.White, shape = RoundedCornerShape(10.dp)),
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    keyboardType = KeyboardType.Text
                                ),
                                maxLines = 1,
                                singleLine = true,
                                keyboardActions = KeyboardActions(
                                    onDone = { keyboardController?.hide() }),
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = Color.White,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    focusedIndicatorColor = Color.Transparent
                                ),
                                shape = RoundedCornerShape(10.dp)
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            Text(
                                "Email Id",
                                modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
                                style = TextStyle(color = white)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            TextField(
                                value = email,
                                onValueChange = { email = it },
                                label = { Text("Enter email id") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp, end = 10.dp)
                                    .background(Color.White, shape = RoundedCornerShape(10.dp)),
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    keyboardType = KeyboardType.Email
                                ),
                                maxLines = 1,
                                singleLine = true,
                                keyboardActions = KeyboardActions(
                                    onDone = { keyboardController?.hide() }),
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = Color.White,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    focusedIndicatorColor = Color.Transparent
                                ),
                                shape = RoundedCornerShape(10.dp)
                            )

                            Spacer(modifier = Modifier.height(20.dp))
                            Text(
                                "Password",
                                modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
                                style = TextStyle(color = white)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            TextField(
                                value = password,
                                onValueChange = { password = it },
                                label = { Text("Enter password") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp, end = 10.dp)
                                    .background(Color.White, shape = RoundedCornerShape(10.dp)),
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    keyboardType = KeyboardType.Password
                                ),
                                maxLines = 1,
                                singleLine = true,
                                keyboardActions = KeyboardActions(
                                    onDone = { keyboardController?.hide() }),
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = Color.White,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    focusedIndicatorColor = Color.Transparent
                                ),
                                visualTransformation = PasswordVisualTransformation(),
                                shape = RoundedCornerShape(10.dp)
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            Text(
                                "Confirm Password",
                                modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
                                style = TextStyle(color = white)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            TextField(
                                value = confirmPassword,
                                onValueChange = { confirmPassword = it },
                                label = { Text("Enter confirm password") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp, end = 10.dp)
                                    .background(Color.White, shape = RoundedCornerShape(10.dp)),
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    keyboardType = KeyboardType.Password
                                ),
                                maxLines = 1,
                                singleLine = true,
                                keyboardActions = KeyboardActions(
                                    onDone = { keyboardController?.hide() }),
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = Color.White,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    focusedIndicatorColor = Color.Transparent
                                ),
                                visualTransformation = PasswordVisualTransformation(),
                                shape = RoundedCornerShape(10.dp)
                            )
                            Spacer(modifier = Modifier.height(40.dp))
                            Button(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp, end = 10.dp)
                                ,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = blue
                                ),
                                contentPadding = PaddingValues(),
                                shape = RoundedCornerShape(10.dp),
                                onClick = {

                                },
                            ) {
                                Box(
                                    modifier = Modifier
                                        .background(white)
                                        .then(
                                            Modifier
                                                .padding(vertical = 5.dp)
                                                .fillMaxWidth()
                                        ),
                                    contentAlignment = Alignment.Center,
                                ) {
                                    Text(
                                        text = "Sign Up",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        modifier = Modifier.padding(10.dp)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(40.dp))
                            Box(modifier = Modifier.fillMaxSize()) {
                                Surface(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(100.dp)
                                        .align(Alignment.BottomCenter),
                                    shape = customBottomShape,
                                    color = white
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(16.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            " Sign In", modifier = Modifier.clickable {
                                                navController.navigate("SignIn")
                                            }, textAlign = TextAlign.End,
                                            style = TextStyle(
                                                color = blue,
                                                fontWeight = FontWeight.Bold
                                            )
                                        )
                                    }
                                }
                            }
                        }
                    }
                }


            }
            if (scroller) {
                Dialog(
                    onDismissRequest = { },
                    DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(100.dp)
                            .background(white, shape = RoundedCornerShape(8.dp))
                    ) {
                        CircularProgressIndicator(color = blue)
                    }
                }
            }

        }
    }
}