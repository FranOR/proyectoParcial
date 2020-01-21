package org.bedu.retrofitsalinas.view.doctor

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_nueva_incidencia.*
import org.bedu.retrofitsalinas.R
import org.bedu.retrofitsalinas.model.IncidenciaRetrofit
import org.bedu.retrofitsalinas.presenter.PresenterRetroIncidencia
import org.bedu.retrofitsalinas.view.MainActivity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class NuevaIncidencia : AppCompatActivity() {
    val presenter = PresenterRetroIncidencia()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_incidencia)


        btnEnviarInc.setOnClickListener {
            var titulo = tituloIncidencia.text.toString()
            var categoria = categoriaIncidencia.text.toString()

            //var dia = LocalDateTime.now().dayOfMonth.toString()
            //var mes = LocalDateTime.now().month.toString()
            //var ano = LocalDateTime.now().year.toString()
            //var hora = LocalDateTime.now().
            var date = getFormatedDate()
            var descripcion = descripcionIncidencia.text.toString()
            //var folio = serviciosIncidencia.obtenerUltimoId()

            //serviciosIncidencia.crearIncidencia(folio,titulo,categoria,date,0,"0000",descripcion)
            val incidencia = IncidenciaRetrofit(0,"Incidencia Retrofit","Fecha","Categoria","descripcion",11)
            presenter.crearIncidencias(incidencia)
            val intento = Intent(this, MainActivity::class.java)
            intento.putExtra("request","incidencias")
            startActivity(intento)
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun getFormatedDate():String{
        val localDateTime =LocalDateTime.parse(LocalDateTime.now().toString())
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
        val output: String = formatter.format(localDateTime)

        return output
    }


}
