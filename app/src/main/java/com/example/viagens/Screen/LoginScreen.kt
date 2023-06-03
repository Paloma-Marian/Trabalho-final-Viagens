package com.example.viagens.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.coroutines.launch

//esses on.. server pra o navegate
@Composable
fun LoginScreen(onNavigateHome: (usuario: String) -> Unit, onBack: () -> Unit, onNavigateNovo: () -> Unit)  {
    val usuario = remember { mutableStateOf("TESTE")}
    val senha = remember { mutableStateOf("TESTE")}
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        val navController = rememberNavController()

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

        //Chama Tela de novo Usuario
        Button(onClick = { onNavigateNovo() }) {
            Text(text = "Novo")
        }

        //Valida usuario e loga no sistema
        Button(onClick = { onNavigateHome(usuario.value) }) {
            Text("OK")
        }
    }

}