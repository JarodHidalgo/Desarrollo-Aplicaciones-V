package com.example.ingresosegresos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.ingresosegresos.data.TransaccionDao
import com.example.ingresosegresos.data.Transaccion
import kotlinx.coroutines.Dispatchers

class TransaccionViewModel(private val transaccionDao: TransaccionDao) : ViewModel() {
    fun getTransaccionesPorMes(userId: Int, periodo: String): LiveData<List<Transaccion>> {
        return transaccionDao.getTransaccionesPorMes(userId, periodo)
    }

    fun getTotalIngresos(userId: Int, periodo: String): LiveData<Double> {
        return transaccionDao.getTotalIngresos(userId, periodo)
    }

    fun getTotalEgresos(userId: Int, periodo: String): LiveData<Double> {
        return transaccionDao.getTotalEgresos(userId, periodo)
    }

    fun insertTransaccion(transaccion: Transaccion) {
        liveData(Dispatchers.IO) {
            transaccionDao.insertTransaccion(transaccion)
        }
    }
}