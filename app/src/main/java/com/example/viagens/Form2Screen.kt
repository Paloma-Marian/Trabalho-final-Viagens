package com.example.viagens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Form2Screen(param: String?) {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation() {
                BottomNavigationItem(
                    selected = true,
                    onClick = { navController.navigate("Tela1") },
                    label = {
                        Text(text = "Tela 1")
                    },
                    icon = { Icon(Icons.Filled.Add, contentDescription = "")
                    })
                BottomNavigationItem(
                    selected = false,
                    onClick = { navController.navigate("Tela2") },
                    label = {
                        Text(text = "Tela 2")
                    },
                    icon = { Icon(Icons.Filled.AccountBox, contentDescription = "")
                    })
                BottomNavigationItem(
                    selected = false,
                    onClick = { navController.navigate("Tela3") },
                    label = {
                        Text(text = "Tela 3")
                    },
                    icon = { Icon(Icons.Filled.Home, contentDescription = "")
                    })


            }
        }
    ){
        NavHost(navController = navController
            , startDestination = "Tela1",
            modifier = Modifier.padding(paddingValues = it)
        ) {
            composable("Tela1") {
                Tela1()
            }
            composable("Tela2") {
                Tela2()
            }
            composable("tela3") {
                Tela3()
            }
        }
    }
}