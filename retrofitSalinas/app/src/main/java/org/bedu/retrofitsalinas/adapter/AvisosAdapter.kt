package org.bedu.retrofitsalinas.adapter

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_aviso.view.*
import org.bedu.retrofitsalinas.R
import org.bedu.retrofitsalinas.model.Aviso

class AvisosAdapter(var lista: List<Aviso>, var context: Context) :
    RecyclerView.Adapter<AvisosAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var vista = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_aviso, parent, false)

        return MyViewHolder(vista,context)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var incidencia = lista.get(position)
        holder.enlazarItem(incidencia)
    }

    class MyViewHolder(itemView: View, contexto:Context) : RecyclerView.ViewHolder(itemView) {


        var context = contexto

        fun enlazarItem(aviso: Aviso) {
            itemView.tvATitulo.text = aviso.titulo
            itemView.tvAFecha.text = aviso.fecha
            itemView.tvAId.text = aviso.id.toString()

            itemView.setOnClickListener(View.OnClickListener {


                //Toast.makeText(context,"Se oprimio2: $adapterPosition",Toast.LENGTH_SHORT).show()
                var  builder = AlertDialog.Builder(context);
                builder.setTitle(aviso.titulo)
                    .setMessage(aviso.descripcion)
                    .setNegativeButton("Regresar", null)
                builder.create().show()
            })

        }

    }



}