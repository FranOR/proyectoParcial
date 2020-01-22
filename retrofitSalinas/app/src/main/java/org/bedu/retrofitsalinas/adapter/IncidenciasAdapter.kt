package org.bedu.retrofitsalinas.adapter

import android.content.Context
import android.content.DialogInterface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_incidencia.view.*
import org.bedu.retrofitsalinas.R
import org.bedu.retrofitsalinas.model.ChangeStatus
import org.bedu.retrofitsalinas.model.Incidencia
import org.bedu.retrofitsalinas.model.Respuesta
import org.bedu.retrofitsalinas.presenter.IncidenciasPresenterImp
import org.bedu.retrofitsalinas.view.doctor.IncidenciasView
import retrofit2.http.Body

class IncidenciasAdapter(var lista: List<Incidencia>, var context: Context) :
    RecyclerView.Adapter<IncidenciasAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var vista = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_incidencia, parent, false)

        return MyViewHolder(vista,context)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var incidencia = lista.get(position)
        holder.enlazarItem(incidencia)
    }

    class MyViewHolder(itemView: View, contexto:Context) : RecyclerView.ViewHolder(itemView),IncidenciasView {
        override fun refrescarLista(respuesta: Respuesta) {

        }

        override fun mostrarIncidencias(listIncidencias: List<Incidencia>) {

        }

        var context = contexto
        val presenter = IncidenciasPresenterImp(this)
        fun enlazarItem(incidencia: Incidencia) {
            itemView.tvTitulo.text = incidencia.titulo
            itemView.tvCategoria.text = incidencia.categoria
            itemView.tvDate.text = incidencia.fecha
            itemView.tvFolio.text = incidencia.folio.toString()

            when(incidencia.estado){
                0 ->
                    itemView.ivIncidencia.setImageResource(R.drawable.ic_warning)
                1 ->
                    itemView.ivIncidencia.setImageResource(R.drawable.ic_access)
                2 ->
                    itemView.ivIncidencia.setImageResource(R.drawable.ic_check)
            }

            itemView.setOnClickListener(View.OnClickListener {

                // Set click listener for alert dialog buttons

                val dialogClickListener = DialogInterface.OnClickListener {
                        dialog, which ->
                    when (which) {
                        DialogInterface.BUTTON_POSITIVE ->{
                            Log.d("MENSAJE", incidencia.folio.toString())
                            presenter.cambiarEstado("cambiarEstatus",ChangeStatus(incidencia.folio,1))
                        }

                        DialogInterface.BUTTON_NEGATIVE -> {
                            presenter.cambiarEstado("cambiarEstatus",ChangeStatus(incidencia.folio,2))
                        }
                    }
                }

                //Toast.makeText(context,"Se oprimio2: $adapterPosition",Toast.LENGTH_SHORT).show()
                var  builder = AlertDialog.Builder(context);
                builder.setTitle(incidencia.titulo)
                    .setMessage(incidencia.desripcion)
                    .setNegativeButton("Marcar como 'Resuelto'", dialogClickListener)
                    .setNeutralButton("Regresar", null)
                    .setPositiveButton("Marcar como 'Pendiente'", dialogClickListener);


                builder.create().show()
            })



        }

    }
    /**
    fun solucionarIncidencia(incidencia:Incidencia){
        var  builder = AlertDialog.Builder(context);
        builder.setTitle(incidencia.titulo)
            .setMessage(incidencia.descripcion)
            .setNegativeButton("Marcar como 'Resuelto'", null)
            .setNeutralButton("Regresar", null)

            .setPositiveButton("Marcar como 'Pendiente'", null);


        builder.create().show()
    }

    **/
}