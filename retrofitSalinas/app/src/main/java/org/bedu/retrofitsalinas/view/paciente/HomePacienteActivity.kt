package org.bedu.retrofitsalinas.view.paciente

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.home_empresarial.*
import org.bedu.retrofitsalinas.R

class HomePacienteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_paciente)

        val intento = Intent(this, InfoDoctorActivity::class.java)

        buttonAsistencia.setOnClickListener {
            intento.putExtra("request","doctores")
            startActivity(intento)
        }

        buttonAvisos.setOnClickListener {
            intento.putExtra("request","citas")
            startActivity(intento)
        }
        buttonIncidencia.setOnClickListener {
            intento.putExtra("request","clinicas")
            startActivity(intento)
        }

        buttonConf.setOnClickListener {
            intento.putExtra("request","configuracion")
            startActivity(intento)
        }
    }
}
