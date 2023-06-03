package com.example.viagens.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viagens.Repository.RepositorioUsuario
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LoginViewModel (private val userRepository: RepositorioUsuario): ViewModel() {

    var name by mutableStateOf("")
    var password by mutableStateOf("")

    private val _toastMessage = MutableSharedFlow<String>()
    val toastMessage = _toastMessage.asSharedFlow()


    fun validateLogin(onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val usuario = userRepository.findByName(name)
            val result = usuario != null && usuario.password == password
            onResult(result)
            if (!result )
                _toastMessage.emit("Invalid login")
        }

    }
}