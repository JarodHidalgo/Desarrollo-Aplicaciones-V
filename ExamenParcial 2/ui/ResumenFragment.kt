package com.example.ingresosegresos.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ingresosegresos.data.AppDatabase
import com.example.ingresosegresos.databinding.FragmentResumenBinding
import com.example.ingresosegresos.viewmodel.TransaccionViewModel

class ResumenFragment : Fragment() {
    private lateinit var binding: FragmentResumenBinding
    private val viewModel: TransaccionViewModel by viewModels {
        TransaccionViewModelFactory(AppDatabase.getInstance(requireContext()).transaccionDao())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentResumenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userId = 1  // Obtener de sesión
        val periodo = "2025-01"  // Ejemplo

        viewModel.getTotalIngresos(userId, periodo).observe(viewLifecycleOwner, Observer { ingresos ->
            binding.tvIngresos.text = "Ingresos: $ingresos"
        })
        viewModel.getTotalEgresos(userId, periodo).observe(viewLifecycleOwner, Observer { egresos ->
            binding.tvEgresos.text = "Egresos: $egresos"
            val saldo = (ingresos ?: 0.0) - (egresos ?: 0.0)
            binding.tvSaldo.text = "Saldo: $saldo"
        })

        // RecyclerView para lista de transacciones
        binding.rvTransacciones.layoutManager = LinearLayoutManager(context)
        viewModel.getTransaccionesPorMes(userId, periodo).observe(viewLifecycleOwner, Observer { list ->
            binding.rvTransacciones.adapter = TransaccionAdapter(list)
        })
    }
}