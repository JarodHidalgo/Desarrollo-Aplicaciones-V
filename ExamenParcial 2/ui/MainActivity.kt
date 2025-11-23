package com.example.ingresosegresos.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ingresosegresos.R
import com.example.ingresosegresos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Navegación básica (puedes usar NavController)
        binding.btnIngresos.setOnClickListener { /* Abrir fragment de ingresos */ }
        binding.btnEgresos.setOnClickListener { /* Abrir fragment de egresos */ }
        binding.btnResumen.setOnClickListener { /* Abrir resumen */ }
    }

    val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "ingresos_egresos.db").build()
}

