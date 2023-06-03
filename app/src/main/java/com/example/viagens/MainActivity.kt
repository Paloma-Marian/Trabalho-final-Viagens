package com.example.viagens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.viagens.Screen.HomeScreen
import com.example.viagens.Screen.LoginScreen
import com.example.viagens.Screen.NovoLoginScreen
import com.example.viagens.ui.theme.ViagensTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViagensTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(){
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    NavHost(navController = navController, startDestination = "login"){
        composable("login"){
            LoginScreen(onBack = {
                navController.navigateUp()
            },
                onNavigateHome = {
                    navController.navigate("Viagens/${it}")
                },
                onNavigateNovo = {
                    navController.navigate("Novo")
                }
            )
        }
        composable("Viagens/{nome}",
            arguments = listOf(
                navArgument("nome") { type = NavType.StringType}
            )
        ){
            val param = it.arguments?.getString("nome")
            HomeScreen(param)
        }
        composable("Novo") {
            NovoLoginScreen(
                onNavigateNovo = {
                    navController.navigateUp()
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(
                            message = "Usuário registrado"
                        )
                    }
                },
                onBack = {
                    navController.navigateUp()
                })
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ViagensTheme {
        MyApp()
    }
}