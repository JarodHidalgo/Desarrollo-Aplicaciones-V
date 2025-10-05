package com.example.calculadorasalario  

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    // IDs de los elementos UI
    private lateinit var etNombre: EditText
    private lateinit var etSalario: EditText
    private lateinit var tvINSS: TextView
    private lateinit var tvIR: TextView
    private lateinit var tvTotalDeduccion: TextView
    private lateinit var tvSalarioNeto: TextView
    private lateinit var btnCalcular: Button
    private lateinit var btnNuevo: Button
    private lateinit var btnSalir: Button

    // Formateador para decimales (2 lugares)
    private val df = DecimalFormat("#.##")

    // Constantes para cálculos (Nicaragua, aproximado 2023)
    private val tasaINSS = 0.0625  // 6.25%
    private val exencionMensual = 6945.0  // Aprox. 1 SMN en córdobas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar vistas
        etNombre = findViewById(R.id.etNombre)
        etSalario = findViewById(R.id.etSalario)
        tvINSS = findViewById(R.id.tvINSS)
        tvIR = findViewById(R.id.tvIR)
        tvTotalDeduccion = findViewById(R.id.tvTotalDeduccion)
        tvSalarioNeto = findViewById(R.id.tvSalarioNeto)
        btnCalcular = findViewById(R.id.btnCalcular)
        btnNuevo = findViewById(R.id.btnNuevo)
        btnSalir = findViewById(R.id.btnSalir)

        // Evento del botón Calcular
        btnCalcular.setOnClickListener {
            calcularSalario()
        }

        // Evento del botón Nuevo
        btnNuevo.setOnClickListener {
            nuevo()
        }

        // Evento del botón Salir
        btnSalir.setOnClickListener {
            finish()  // Cierra la actividad/app
        }
    }

    /**
     * Función para validar entradas y calcular deducciones.
     */
    private fun calcularSalario() {
        // Validar nombre
        val nombre = etNombre.text.toString().trim()
        if (nombre.isEmpty()) {
            Toast.makeText(this, "Error: Ingrese el nombre completo.", Toast.LENGTH_SHORT).show()
            return
        }

        // Validar salario
        val salarioStr = etSalario.text.toString().trim()
        if (salarioStr.isEmpty()) {
            Toast.makeText(this, "Error: Ingrese el salario.", Toast.LENGTH_SHORT).show()
            return
        }

        val salario: Double
        try {
            salario = salarioStr.toDouble()
            if (salario <= 0) {
                Toast.makeText(this, "Error: El salario debe ser mayor a 0.", Toast.LENGTH_SHORT).show()
                return
            }
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Error: El salario debe ser un número válido.", Toast.LENGTH_SHORT).show()
            return
        }

        // Calcular INSS
        val inss = salario * tasaINSS

        // Calcular base para IR (salario - INSS - exención)
        val baseIR = salario - inss - exencionMensual
        val ir = if (baseIR > 0) {
            calcularIR(baseIR)
        } else {
            0.0
        }

        // Total deducción e neto
        val totalDeduccion = inss + ir
        val salarioNeto = salario - totalDeduccion

        // Mostrar resultados
        tvINSS.text = "INSS: C$ ${df.format(inss)}"
        tvIR.text = "IR: C$ ${df.format(ir)}"
        tvTotalDeduccion.text = "Total deducción: C$ ${df.format(totalDeduccion)}"
        tvSalarioNeto.text = "Salario neto: C$ ${df.format(salarioNeto)}"

        Toast.makeText(this, "Cálculo realizado para $nombre.", Toast.LENGTH_SHORT).show()
    }

    /**
     * Función para calcular IR progresivo (simplificado para Nicaragua).
     */
    private fun calcularIR(base: Double): Double {
        return when {
            base <= 0 -> 0.0
            base <= (13890 - exencionMensual) -> base * 0.15  // Primer tramo: 15%
            base <= (27780 - exencionMensual) -> {
                val excedente1 = (13890 - exencionMensual)
                val ir1 = excedente1 * 0.15
                val excedente2 = base - excedente1
                ir1 + (excedente2 * 0.20)  // Segundo tramo: 20%
            }
            else -> {
                val excedente1 = (13890 - exencionMensual)
                val excedente2 = (27780 - exencionMensual) - excedente1
                val ir1 = excedente1 * 0.15
                val ir2 = excedente2 * 0.20
                val excedente3 = base - (excedente1 + excedente2)
                ir1 + ir2 + (excedente3 * 0.30)  // Tercer tramo: 30%
            }
        }
    }

    /**
     * Función para limpiar campos (botón Nuevo).
     */
    private fun nuevo() {
        etNombre.text.clear()
        etSalario.text.clear()
        tvINSS.text = "INSS: C$ 0.00"
        tvIR.text = "IR: C$ 0.00"
        tvTotalDeduccion.text = "Total deducción: C$ 0.00"
        tvSalarioNeto.text = "Salario neto: C$ 0.00"
        Toast.makeText(this, "Campos limpiados.", Toast.LENGTH_SHORT).show()
    }
}
