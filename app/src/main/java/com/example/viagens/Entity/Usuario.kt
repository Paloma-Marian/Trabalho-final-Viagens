package com.example.viagens.Entity

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Tabela dos dados 1 usuário pra muitas viagens
@Entity(tableName = "usuario")
data class Usuario (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val email: String,
    val password: String){
}