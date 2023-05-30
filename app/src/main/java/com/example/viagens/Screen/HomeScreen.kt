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
                    selected = false,
                    onClick = { navController.navigate("Novo") },
                    label = {
                        Text(text = "Novo")
                    },
                    icon = { Icon(Icons.Filled.Add, contentDescription = "")
                    })
                BottomNavigationItem(
                    selected = true,
                    onClick = { navController.navigate("Viagens") },
                    label = {
                        Text(text = "Viagens")
                    },
                    icon = { Icon(Icons.Filled.Home, contentDescription = "")
                    })
                BottomNavigationItem(
                    selected = false,
                    onClick = { navController.navigate("Sobre") },
                    label = {
                        Text(text = "Sobre")
                    },
                    icon = { Icon(Icons.Filled.AccountBox, contentDescription = "")
                    })


            }
        }
    ){
        NavHost(navController = navController
            , startDestination = "Viagens",
            modifier = Modifier.padding(paddingValues = it)
        ) {
            composable("Novo") {
                NovaViagem()
            }
            composable("Viagens") {
                Viagem()
            }
            composable("Sobre") {
                Sobre()
            }
        }
    }
}