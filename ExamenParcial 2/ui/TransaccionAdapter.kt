package com.example.ingresosegresos.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ingresosegresos.data.Transaccion
import com.example.ingresosegresos.databinding.ItemTransaccionBinding

class TransaccionAdapter(private val transacciones: List<Transaccion>) : RecyclerView.Adapter<TransaccionAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemTransaccionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTransaccionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val trans = transacciones[position]
        holder.binding.tvMonto.text = trans.monto.toString()
        holder.binding.tvFecha.text = trans.fecha
        holder.binding.tvDescripcion.text = trans.descripcion
    }

    override fun getItemCount() = transacciones.size
}