package org.bedu.retrofitsalinas.view.doctor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.home_empresarial.*
import org.bedu.retrofitsalinas.R

class HomeEmpresarialActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_empresarial)

        val intento = Intent(this, MainActivity::class.java)

        buttonAsistencia.setOnClickListener {
            intento.putExtra("request","asistencia")
            startActivity(intento)
        }

        buttonAvisos.setOnClickListener {
            intento.putExtra("request","avisos")
            startActivity(intento)
        }
        buttonIncidencia.setOnClickListener {
            intento.putExtra("request","incidencias")
            startActivity(intento)
        }

        buttonConf.setOnClickListener {
            intento.putExtra("request","configuracion")
            startActivity(intento)
        }
    }
}