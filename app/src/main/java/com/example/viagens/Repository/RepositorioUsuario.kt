package com.example.viagens.Repository

import com.example.viagens.Dao.UsuarioDao
import com.example.viagens.Entity.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RepositorioUsuario (private val usuarioDao: UsuarioDao) {


    private val coroutine = CoroutineScope(Dispatchers.Main)

    fun addUsuario(usuario: Usuario) {
        coroutine.launch(Dispatchers.IO) {
            usuarioDao.insert(usuario)
        }
    }

    fun delete(usuario: Usuario) {
        coroutine.launch(Dispatchers.IO) {
            usuarioDao.delete(usuario)
        }
    }

    suspend fun CarregaTodosUsuarios(): List<Usuario> {
        return usuarioDao.getAll()
    }

    suspend fun findByName(name: String): Usuario? =
        usuarioDao.findByName(name)

}