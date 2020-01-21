package org.bedu.retrofitsalinas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.dates_item.view.*
import org.bedu.retrofitsalinas.R
import org.bedu.retrofitsalinas.model.Cita

class DatesAdapter (var lista: List<Cita>) : RecyclerView.Adapter<DatesAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.dates_item, parent, false)
        return MyViewHolder(vista)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var cita = lista.get(position)
        holder.enlazarItem(cita)
    }

    class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        fun enlazarItem(cita: Cita) {
            itemView.txtDoctor.text = "${cita.nombreDoctor}"
            itemView.tvAsunto.text = "${cita.asunto}"
            itemView.txtFecha.text = "${cita.fecha}"
            itemView.txtClinica.text = "Clinica: ${cita.clinica}"
        }
    }
}