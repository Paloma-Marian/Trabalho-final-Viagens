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
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        //registrar novo Usuario
        Button(onClick = { onNavigateNovo() }) {
            Text(text = "Cadastro no sistema")
        }

        //Valida usuario e loga no sistema
        Button(onClick = { onNavigateHome("") }) {
            Text("OK")
        }
    }

}