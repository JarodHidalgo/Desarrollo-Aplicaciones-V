package com.example.ingresosegresos.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity
data class Usuario(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val username: String,
    val password: String  // Hashear en producción
)

@Entity
data class Categoria(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val tipo: String  // "INGRESO" o "EGRESO"
)

@Entity(
    foreignKeys = [
        ForeignKey(entity = Usuario::class, parentColumns = ["id"], childColumns = ["usuario_id"]),
        ForeignKey(entity = Categoria::class, parentColumns = ["id"], childColumns = ["categoria_id"])
    ]
)
data class Transaccion(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val usuario_id: Int,
    val categoria_id: Int,
    val monto: Double,
    val fecha: String,  // YYYY-MM-DD
    val descripcion: String = "",
    val es_recurrencia: Boolean = false,
    val frecuencia: String = ""  // "MENSUAL"
)

@Entity(
    foreignKeys = [
        ForeignKey(entity = Transaccion::class, parentColumns = ["id"], childColumns = ["transaccion_id"])
    ]
)
data class Recurrencia(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val transaccion_id: Int,
    val fecha_inicio: String,
    val fecha_fin: String? = null
)