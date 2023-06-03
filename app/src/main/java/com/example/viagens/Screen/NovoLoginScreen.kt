package com.example.viagens.Screen

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viagens.ViewModel.RegistraNovoUsuarioViewModel
import com.example.viagens.ViewModel.RegistraNovoUsuarioViewModelFactory
import kotlinx.coroutines.flow.collectLatest

@Composable
fun NovoLoginScreen(onNavigateNovo: () -> Unit, onBack:() -> Unit) {
    val application = LocalContext.current.applicationContext as Application
    val viewModel: RegistraNovoUsuarioViewModel = viewModel(
        factory = RegistraNovoUsuarioViewModelFactory(application)
    )
    val ctx = LocalContext.current
    //feedback para o usuário
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(Unit) {
        viewModel.toastMessage.collectLatest {
            scaffoldState.snackbarHostState.showSnackbar(
                message = it,
                duration = SnackbarDuration.Long
            )
            // opção para mostrar as mensagens
            // Toast.makeText(ctx, it, Toast.LENGTH_SHORT).show()
        }
    }

    val focusManager = LocalFocusManager.current

    Scaffold(scaffoldState = scaffoldState ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            OutlinedTextField(
                value = viewModel.name,
                onValueChange = { viewModel.name = it},
                isError = !viewModel.isNameValid,
                label = {
                    Text(text = "Name")
                }
            )
            OutlinedTextField(
                value = viewModel.email,
                onValueChange = { viewModel.email = it},
                label = {
                    Text(text = "E-mail")
                }
            )
            OutlinedTextField(
                value = viewModel.password,
                onValueChange = { viewModel.password = it},
                label = {
                    Text(text = "Password")
                }
            )
            Row() {
                Button(onClick = {

                    focusManager.clearFocus()
                    viewModel.registrar(onSuccess = {
                        onNavigateNovo()
                    })
                }) {
                    Text(text = "Save")
                }
                Spacer(modifier = Modifier.size(8.dp))
                Button(
                    onClick = {
                        onBack()
                    }) {
                    Text(text = "Back")
                }

            }

        }
    }

}