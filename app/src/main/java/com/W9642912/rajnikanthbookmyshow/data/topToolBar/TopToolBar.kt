package com.W9642912.rajnikanthbookmyshow.data.topToolBar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.W9642912.rajnikanthbookmyshow.R
import com.W9642912.rajnikanthbookmyshow.data.theme.blue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopToolBar(show:Boolean = false,onClick : ()->Unit) {
    SmallTopAppBar(
        title = {
            androidx.compose.material3.Text(
                text = stringResource(id = R.string.app_name), color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
            )
        },
        navigationIcon = {
            if(show) {
                IconButton(
                    onClick = {
                        onClick()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack,
                        tint = Color.White,
                        contentDescription = "Back"
                    )
                }
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = blue,
            titleContentColor = Color.White
        )
    )
}