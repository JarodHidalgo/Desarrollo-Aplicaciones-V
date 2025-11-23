package com.example.ingresosegresos.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Usuario::class, Categoria::class, Transaccion::class, Recurrencia::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
    abstract fun categoriaDao(): CategoriaDao
    abstract fun transaccionDao(): TransaccionDao
    abstract fun recurrenciaDao(): RecurrenciaDao
}