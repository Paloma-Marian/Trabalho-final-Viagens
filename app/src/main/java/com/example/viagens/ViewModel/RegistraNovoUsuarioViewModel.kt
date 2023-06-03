package com.example.viagens.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viagens.Dao.UsuarioDao
import com.example.viagens.Entity.Usuario
import com.example.viagens.Repository.RepositorioUsuario
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class RegistraNovoUsuarioViewModel (private val userRepository: RepositorioUsuario): ViewModel() {

    var name by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    var isNameValid by mutableStateOf(true)

    private val _toastMessage = MutableSharedFlow<String>()
    val toastMessage = _toastMessage.asSharedFlow()

    private fun validateFields() {
        isNameValid = name.isNotEmpty()
        if (!isNameValid) {
            throw Exception("Name is required")
        }
    }

    //registra o usuário na base de dados
    fun registrar(onSuccess: () -> Unit) {
        try {
            validateFields()
            val newUser = Usuario(name = name, email = email, password = password)
            userRepository.addUsuario(newUser)
            onSuccess()
        }
        catch (e: Exception) {
            viewModelScope.launch {
                _toastMessage.emit(e.message?: "Unknown error")
            }
        }

    }

}