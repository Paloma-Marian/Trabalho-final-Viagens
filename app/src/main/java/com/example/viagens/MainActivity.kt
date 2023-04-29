package com.example.viagens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.viagens.ui.theme.ViagensTheme

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
    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            HomeScreen(onBack = {
                navController.navigateUp()
            },
                onNavigateHome = {
                    navController.navigate("Form2/${it}")
                }
            )
        }
        composable("Form2/{nome}",
            arguments = listOf(
                navArgument("nome") { type = NavType.StringType}
            )
        ){
            val param = it.arguments?.getString("nome")
            Form2Screen(param)
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