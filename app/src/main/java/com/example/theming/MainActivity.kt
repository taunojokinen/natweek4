package com.example.theming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.theming.ui.theme.MyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                Surface(
                    modifier =
                    Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.secondary
                ) {
                  Theming()
                }
            }
        }
    }
}

@Composable
fun Theming() {

    val appModifier = Modifier
        .fillMaxWidth()
        .padding(24.dp)

    val themeText = if (isSystemInDarkTheme()) "Dark Theme" else "Light Theme"

    val isSystemDarkTheme = isSystemInDarkTheme()
    var isDarkTheme by remember { mutableStateOf(isSystemDarkTheme) }



    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,


    ) {
        Text(
            text = themeText,
            style = MaterialTheme.typography.headlineSmall  ,
            modifier = appModifier,
        )


        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = appModifier
        )
        Button(
            onClick = {{ isDarkTheme = !isDarkTheme } },
            modifier = appModifier,
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Text(text = "Submit")
        }
    }


}



@Preview(showBackground = true, backgroundColor = 0xFFD7D3D3)
@Composable
fun ThemingPreview() {
    MyTheme {
        Theming()
    }
}