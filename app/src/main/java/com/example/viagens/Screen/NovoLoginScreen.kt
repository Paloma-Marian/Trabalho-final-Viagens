package com.example.viagens.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun NovoLoginScreen(onNavigateNovo: (nome: String) -> Unit, onBack: () -> Unit) {
    val nome = remember {
        mutableStateOf("TESTE")
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)){

        Text(
            text = "Novo Login",
            textAlign = TextAlign.Center
        )
        OutlinedTextField(value = nome.value,
            onValueChange = {
                nome.value = it
            })
        Button(onClick = { onBack }) {
            Text(text = "Back")
        }
        Button(onClick = { onNavigateNovo(nome.value) }) {
            Text("Login")
        }
    }
}