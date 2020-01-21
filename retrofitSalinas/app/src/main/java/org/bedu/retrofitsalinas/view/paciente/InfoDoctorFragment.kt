package org.bedu.retrofitsalinas.view.paciente

import android.content.Intent.getIntent
import android.content.Intent.getIntentOld
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bedu.proyectosalinas.presenter.paciente.InfoDoctorImp
import kotlinx.android.synthetic.main.doctor_info_fragment.*
import org.bedu.retrofitsalinas.R
import org.bedu.retrofitsalinas.model.Doctor
import org.bedu.retrofitsalinas.model.sendId

class InfoDoctorFragment : Fragment(), InfoDoctorView {

    val presenter = InfoDoctorImp(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.doctor_info_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //var test = sendId(1)
        //var reqFragment = getIntent().getStringExtra("request")
        var info = activity?.intent?.getSerializableExtra("infoDoctor") as Doctor
        //presenter.mostrarInfoDoctor(info)
        infoDoctor(info)
    }

    override fun infoDoctor( doctor: Doctor) {
        doctorName.text = doctor.nombre
        especialidadDoc.text = doctor.especialidad
        experienciaDoc.text = doctor.experiencia
        cedulaDoc.text = doctor.cedula
        clinicaDoc.text = doctor.clinica
    }

}
