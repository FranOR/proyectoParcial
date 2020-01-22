package com.bedu.proyectosalinas.view.paciente

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bedu.proyectosalinas.presenter.paciente.ListaDoctorImp
import com.bedu.proyectosalinas.view.doctor.AsistenciaFragment
import kotlinx.android.synthetic.main.lista_doctores_fragment.*
import org.bedu.retrofitsalinas.R
import org.bedu.retrofitsalinas.adapter.ListaDoctoresAdapter
import org.bedu.retrofitsalinas.adapter.OnItemClickListener
import org.bedu.retrofitsalinas.model.Doctor
import org.bedu.retrofitsalinas.view.paciente.InfoDoctorFragment

class ListaDoctorFragment: Fragment(), ListaDoctorView,OnItemClickListener {
    override fun onItemClicked(doctor: Doctor) {
        Toast.makeText(context,doctor.apellidos, Toast.LENGTH_LONG).show()
        val fragment = InfoDoctorFragment()
        val args = Bundle()
        args.putSerializable("infoDoctor", doctor)
        fragment.setArguments(args)
        openFragment(fragment)
        //val intento = Intent(context, InfoDoctorFragment::class.java)
        //intento.putExtra("infoDoctor", doctor)
        //startActivity(intento)
    }


    val presenter = ListaDoctorImp(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.lista_doctores_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.mostrarDoctores()
    }

    override fun llenarRecycler(listaDoctores: List<Doctor>) {
        Log.d("Message", listaDoctores[0].nombre)
        recyclerDoctores.layoutManager = LinearLayoutManager(this.context)
        var miAdapter = ListaDoctoresAdapter(listaDoctores, this)
        recyclerDoctores.adapter = miAdapter
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = activity?.supportFragmentManager!!.beginTransaction()
        transaction.replace(R.id.fragment1, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}