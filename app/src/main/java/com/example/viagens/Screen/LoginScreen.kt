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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun HomeScreen(onNavigateHome: (usuario: String) -> Unit, onBack: () -> Unit)  {
    val usuario = remember { mutableStateOf("TESTE")}
    val senha = remember { mutableStateOf("TESTE")}
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(
            text = "Entrar na Central de Viagens",
            textAlign = TextAlign.Center
        )
        OutlinedTextField(value = usuario.value,
            onValueChange = {
                usuario.value = it
            })
        OutlinedTextField(value = senha.value,
            onValueChange = {
                senha.value = it
            })
        Button(onClick = { onNavigateHome(usuario.value) }) {
            Text("OK")
        }
    }
}