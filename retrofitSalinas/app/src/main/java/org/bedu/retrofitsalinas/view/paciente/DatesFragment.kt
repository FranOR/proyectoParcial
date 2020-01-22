package org.bedu.retrofitsalinas.view.paciente


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_dates.*

import org.bedu.retrofitsalinas.R
import org.bedu.retrofitsalinas.adapter.DatesAdapter
import org.bedu.retrofitsalinas.model.Cita
import org.bedu.retrofitsalinas.presenter.DatesPresenterImp
import org.bedu.retrofitsalinas.adapter.PastDatesAdapter
import org.bedu.retrofitsalinas.model.sendId


/**
 * A simple [Fragment] subclass.
 */
class DatesFragment : Fragment(), DatesView {

    val presenter = DatesPresenterImp(this)
    lateinit var shared: SharedPreferences
    val PREFS_NAME = "sharedpreferences"
    val ID = "ID"
    lateinit var preferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dates, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO ponerlo como string, getPreferences
        shared  = this.activity!!.getSharedPreferences("user", Context.MODE_PRIVATE)
        preferences = context!!.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        //onClick
        //var cita = Cita(1, "2020-30-01 17:00",1, 1)
        //presenter.crearCita(cita, "nuevaCita")
        var idUser = obtenerUserId()

        button.setOnClickListener{
            presenter.obtenerCitasPost(idUser, "getCitas")
        }

        button2.setOnClickListener{
            presenter.obtenerCitasPasadasPost(idUser, "getCitasPasadas")
        }
    }

    override fun obtenerUserId(): sendId {
        return sendId(preferences.getInt(ID,0))
        //return shared.getString("idUsuario", "0").toString()
    }

    override fun llenarRecycler(listaCitas:List<Cita>) {
        recyclerCitas.layoutManager = LinearLayoutManager(this.context)
        var miAdapter = DatesAdapter(listaCitas)
        recyclerCitas.adapter = miAdapter
    }

    override fun llenarRecyclerPasadas(listaCitas: List<Cita>) {
        recyclerCitas.layoutManager = LinearLayoutManager(this.context)
        var miAdapter = PastDatesAdapter(listaCitas)
        recyclerCitas.adapter = miAdapter
    }
}
