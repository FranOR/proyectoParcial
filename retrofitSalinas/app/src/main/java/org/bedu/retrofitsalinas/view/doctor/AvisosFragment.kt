package com.bedu.proyectosalinas.view.doctor

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.fragment_avisos.*

import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.formulario_naviso.view.*
import org.bedu.retrofitsalinas.adapter.AvisosAdapter
import org.bedu.retrofitsalinas.model.Aviso
import org.bedu.retrofitsalinas.presenter.AvisosPresenterImp
import org.bedu.retrofitsalinas.view.doctor.AvisosView
import java.time.LocalDateTime


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AvisosFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 */
class AvisosFragment : Fragment(),AvisosView {
    override fun avisoCreado(respuesta: String) {

        Toast.makeText(context, respuesta, Toast.LENGTH_SHORT).show()
    }

    lateinit var vista:View

    override fun mostrarAvisos(listAvisos:List<Aviso>) {
        var adaptador = AvisosAdapter(listAvisos,vista.context)

        recyclerAvisos.layoutManager = LinearLayoutManager(vista.context)
        recyclerAvisos.adapter = adaptador
    }

    val presenter = AvisosPresenterImp(this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista= inflater.inflate(org.bedu.retrofitsalinas.R.layout.fragment_avisos, container, false)
        return vista
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        floatingActionButton.setOnClickListener {
            val content = LayoutInflater.from(context).inflate(org.bedu.retrofitsalinas.R.layout.formulario_naviso, null)

            val dialog = AlertDialog.Builder(content.context)
            dialog.setView(content)
            dialog.setTitle("Nuevo Aviso")
            dialog.setPositiveButton("Crear Aviso") { dialog, which ->

                var titulo = content.txtATitulo.text.toString()
                var descripcion = content.txtADescripcion.text.toString()

                var naviso = Aviso(1,LocalDateTime.now().toString(),titulo,descripcion)
                // Do something when user press the positive button
                presenter.crearAviso("nuevoAviso",naviso)

            }

            val dialogshow = dialog.create()
            dialogshow.show()


        }


        presenter.obtenerAvisos("getAvisos")

    }




}
