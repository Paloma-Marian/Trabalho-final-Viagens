package com.example.viagens.DataBase

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.viagens.Dao.UsuarioDao
import com.example.viagens.Entity.Usuario

//faz a instância da base...
@Database(entities = [Usuario::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun usuarioDao (): UsuarioDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(application: Application): AppDatabase = INSTANCE ?: synchronized(this){
            val instance = Room.databaseBuilder(
                application,
                AppDatabase::class.java,
                "my-db1"
            ).build()
            INSTANCE = instance
            instance
        }
    }

}