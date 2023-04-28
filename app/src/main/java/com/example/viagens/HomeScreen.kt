package com.example.viagens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun HomeScreen(onNavigateHome: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Home",
            textAlign = TextAlign.Center
        )
        Button(onClick ={
            onNavigateHome()
        }){
            Text(text = "Navigate to Home")
        }
    }
}