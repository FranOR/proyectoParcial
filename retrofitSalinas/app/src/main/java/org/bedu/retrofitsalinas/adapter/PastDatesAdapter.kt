package org.bedu.retrofitsalinas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.dates_item.view.*
import kotlinx.android.synthetic.main.dates_item.view.txtDoctor
import kotlinx.android.synthetic.main.dates_item.view.txtFecha
import kotlinx.android.synthetic.main.past_dates_item.view.*
import org.bedu.retrofitsalinas.R
import org.bedu.retrofitsalinas.model.Cita

class PastDatesAdapter (var lista: List<Cita>) : RecyclerView.Adapter<PastDatesAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.past_dates_item, parent, false)
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
            itemView.txtDoctor.text = "FECHA: ${cita.nombreDoctor}"
            itemView.txtHora.text = "FECHA: ${cita.fecha}"
            itemView.txtFecha.text = "FECHA: ${cita.fecha}"
            itemView.ratingBar2.rating =
                if(cita.id > 5) {5.0F} else {cita.id.toFloat()}
        }
    }
}