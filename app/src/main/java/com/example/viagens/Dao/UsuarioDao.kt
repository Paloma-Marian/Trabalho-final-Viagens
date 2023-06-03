package com.example.viagens.Dao

import androidx.room.*
import com.example.viagens.Entity.Usuario

@Dao
interface UsuarioDao {

   @Insert
    fun insert(usuario: Usuario)

    @Update
    suspend fun update(usuario: Usuario)

    @Delete
    suspend fun delete(usuario: Usuario)

    @Query("select * from usuario u order by u.name ")
    suspend fun getAll(): List<Usuario>

    @Query("select * from usuario u where u.name = :name")
    suspend fun findByName(name: String): Usuario

}