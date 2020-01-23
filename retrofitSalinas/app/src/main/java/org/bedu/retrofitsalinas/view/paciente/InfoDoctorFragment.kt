package org.bedu.retrofitsalinas.view.paciente

import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bedu.proyectosalinas.presenter.paciente.InfoDoctorImp
import com.google.gson.annotations.SerializedName
import kotlinx.android.synthetic.main.doctor_info_fragment.*
import kotlinx.android.synthetic.main.time_alert.*
import kotlinx.android.synthetic.main.time_alert.view.*
import org.bedu.retrofitsalinas.R
import org.bedu.retrofitsalinas.model.Cita
import org.bedu.retrofitsalinas.model.Doctor
import org.bedu.retrofitsalinas.model.Fechas
import org.bedu.retrofitsalinas.model.sendId
import org.bedu.retrofitsalinas.presenter.FechasPresenter

class InfoDoctorFragment : Fragment(), InfoDoctorView {


    val presenter = InfoDoctorImp(this)
    val PREFS_NAME = "sharedpreferences"
    val ID = "ID"
    lateinit var info:Doctor
    lateinit var preferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.doctor_info_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val presenter = FechasPresenter(this)
        preferences = context!!.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        info = arguments?.getSerializable("infoDoctor") as Doctor
        infoDoctor(info)

        buttonCita.setOnClickListener {
            presenter.obtenerFechas(sendId(info.id))
        }
    }

    override fun customAlert(listaFechas: List<Fechas>) {

        val view = layoutInflater.inflate(R.layout.time_alert, null)
        val stringsOrNulls = arrayOfNulls<String>(listaFechas.size) // returns Array<String?>

        var j = 0
        for(i in listaFechas){
            stringsOrNulls[j] = i.fecha
            j++
        }

        view.spinner.adapter = ArrayAdapter(context!!, android.R.layout.simple_spinner_dropdown_item, stringsOrNulls)


        val dialog = AlertDialog.Builder(context)
        dialog.setTitle("Fechas disponibles")

        dialog.setPositiveButton("Agendar") { dialog, which ->
            var cita = Cita(0, view.spinner.selectedItem.toString(),info.id, preferences.getInt(ID,0),"", "Consulta",0f,"")
            presenter.registrarCita(cita)
        }

        dialog.setNegativeButton(android.R.string.no) { dialog, which ->
            //N/A
        }
        dialog.setView(view)
        dialog.setCancelable(false)

        val dialogShow = dialog.create()
        dialogShow.show()
    }

    override fun infoDoctor( doctor: Doctor) {
        doctorName.text = doctor.nombre
        especialidadDoc.text = doctor.especialidad
        experienciaDoc.text = doctor.experiencia
        cedulaDoc.text = doctor.cedula
        clinicaDoc.text = doctor.clinica
    }

    override fun mostrarToast(mensaje: String) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
    }


}
