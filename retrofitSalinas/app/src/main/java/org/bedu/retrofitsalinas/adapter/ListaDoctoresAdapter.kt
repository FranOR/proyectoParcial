package org.bedu.retrofitsalinas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.doctor_fragment.view.*
import org.bedu.retrofitsalinas.R
import org.bedu.retrofitsalinas.model.Doctor

class ListaDoctoresAdapter(var lista: List<Doctor>, val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<ListaDoctoresAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_fragment, parent, false)
        return MyViewHolder(vista)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var doctor = lista.get(position)
        holder.enlazarItem(doctor, itemClickListener)

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun enlazarItem(doctor: Doctor,clickListener: OnItemClickListener) {
            itemView.doctorName.text = doctor.nombre
            itemView.doctorSpecial.text = doctor.especialidad
            itemView.ratingBar.text = doctor.calificacion

            itemView.setOnClickListener{
                clickListener.onItemClicked(doctor)
            }
        }
    }
}

interface OnItemClickListener{
    fun onItemClicked(doctor: Doctor)
}