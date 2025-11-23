package com.example.ingresosegresos.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UsuarioDao {
    @Query("SELECT * FROM usuario WHERE username = :username AND password = :password LIMIT 1")
    fun getUsuario(username: String, password: String): LiveData<Usuario?>

    @Insert
    suspend fun insertUsuario(usuario: Usuario)
}

@Dao
interface CategoriaDao {
    @Query("SELECT * FROM categoria WHERE tipo = :tipo")
    fun getCategoriasPorTipo(tipo: String): LiveData<List<Categoria>>

    @Insert
    suspend fun insertCategoria(categoria: Categoria)
}

@Dao
interface TransaccionDao {
    @Query("SELECT * FROM transaccion WHERE usuario_id = :userId AND strftime('%Y-%m', fecha) = :periodo")
    fun getTransaccionesPorMes(userId: Int, periodo: String): LiveData<List<Transaccion>>

    @Query("SELECT SUM(monto) FROM transaccion WHERE usuario_id = :userId AND categoria_id IN (SELECT id FROM categoria WHERE tipo = 'INGRESO') AND strftime('%Y-%m', fecha) = :periodo")
    fun getTotalIngresos(userId: Int, periodo: String): LiveData<Double>

    @Query("SELECT SUM(monto) FROM transaccion WHERE usuario_id = :userId AND categoria_id IN (SELECT id FROM categoria WHERE tipo = 'EGRESO') AND strftime('%Y-%m', fecha) = :periodo")
    fun getTotalEgresos(userId: Int, periodo: String): LiveData<Double>

    @Insert
    suspend fun insertTransaccion(transaccion: Transaccion)
}

@Dao
interface RecurrenciaDao {
    @Query("SELECT * FROM recurrencia WHERE transaccion_id = :transId")
    fun getRecurrenciasPorTrans(transId: Int): LiveData<List<Recurrencia>>

    @Insert
    suspend fun insertRecurrencia(recurrencia: Recurrencia)
}