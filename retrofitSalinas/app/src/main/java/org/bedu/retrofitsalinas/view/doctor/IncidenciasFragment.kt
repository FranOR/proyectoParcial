package com.bedu.proyectosalinas.view.doctor


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.incidencias_fragment.*
import org.bedu.retrofitsalinas.R
import org.bedu.retrofitsalinas.view.doctor.NuevaIncidencia


class IncidenciasFragment : Fragment() {
    //lateinit var serviciosIncidencia: ServiciosIncidencia
    lateinit var vista: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.incidencias_fragment, container, false)



        return vista
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        floatingActionButton.setOnClickListener {
            val intento = Intent(vista.context, NuevaIncidencia::class.java)
            startActivity(intento)
        }

        //Toast.makeText(vista.context,"Incidencias: ${listaIncidencia.size.toString()}", Toast.LENGTH_SHORT).show()

        //var adaptador = IncidenciasAdapter(listaIncidencia,vista.context)
        //recyclerIncidencias2.layoutManager = LinearLayoutManager(vista.context)

        //recyclerIncidencias2.adapter = adaptador


    }

}
