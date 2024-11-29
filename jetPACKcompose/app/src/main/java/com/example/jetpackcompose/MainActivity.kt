package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetPACKcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPACKcomposeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                   Column (
                       horizontalAlignment = Alignment.CenterHorizontally,
                       verticalArrangement = Arrangement.Center,
                       modifier = Modifier
                           .padding(innerPadding)
                           .background(Color.Cyan)
                           .fillMaxSize()
                   ){
                       Image(
                           painterResource(R.drawable.ic_launcher_background),
                           contentDescription = null
                       )
                       Spacer(modifier = Modifier.height(16.dp))

                       OutlinedTextField(value = " ", onValueChange = {} )
                       Spacer(modifier = Modifier.height(16.dp))

                       OutlinedTextField(value = " ", onValueChange = {})
                       Spacer(modifier = Modifier.height(16.dp))

                       Button(onClick = {})  {
                           Text(text = "Login")
                       }
                   }

                }

            }
        }
    }
}

@Composable
fun greeting(name :String, modifier: Modifier=Modifier) {
    Text(text = name, modifier = modifier)
}

