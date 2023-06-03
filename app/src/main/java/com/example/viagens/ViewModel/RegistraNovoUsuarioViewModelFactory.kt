package com.example.viagens.ViewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viagens.DataBase.AppDatabase
import com.example.viagens.Repository.RepositorioUsuario

class RegistraNovoUsuarioViewModelFactory (val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dao = AppDatabase.getDatabase(application).usuarioDao()
        val userRepository = RepositorioUsuario(dao)
        return RegistraNovoUsuarioViewModel(userRepository) as T
    }

}