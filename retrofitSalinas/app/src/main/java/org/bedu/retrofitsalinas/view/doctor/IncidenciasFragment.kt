package com.bedu.proyectosalinas.view.doctor


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.incidencias_fragment.*
import org.bedu.retrofitsalinas.R
import org.bedu.retrofitsalinas.adapter.IncidenciasAdapter
import org.bedu.retrofitsalinas.model.Incidencia
import org.bedu.retrofitsalinas.model.sendId
import org.bedu.retrofitsalinas.presenter.AvisosPresenterImp
import org.bedu.retrofitsalinas.presenter.IncidenciasPresenterImp
import org.bedu.retrofitsalinas.view.doctor.IncidenciasView
import org.bedu.retrofitsalinas.view.doctor.NuevaIncidencia


class IncidenciasFragment : Fragment(),IncidenciasView {
    override fun mostrarIncidencias(listIncidencias: List<Incidencia>) {

        var adaptador = IncidenciasAdapter(listIncidencias,vista.context)
        recyclerIncidencias2.layoutManager = LinearLayoutManager(vista.context)

        recyclerIncidencias2.adapter = adaptador
    }

    lateinit var vista: View

    val presenter = IncidenciasPresenterImp(this)
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

        var iduser = sendId(11)
        presenter.obtenerIncidencias("getIncidencias",iduser)
        //Toast.makeText(vista.context,"Incidencias: ${listaIncidencia.size.toString()}", Toast.LENGTH_SHORT).show()




    }

}
