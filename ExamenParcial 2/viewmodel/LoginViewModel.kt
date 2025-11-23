package com.example.ingresosegresos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.ingresosegresos.data.UsuarioDao
import kotlinx.coroutines.Dispatchers

class LoginViewModel(private val usuarioDao: UsuarioDao) : ViewModel() {
    fun login(username: String, password: String): LiveData<Boolean> {
        return liveData(Dispatchers.IO) {
            val user = usuarioDao.getUsuario(username, password).value
            emit(user != null)
        }
    }
}