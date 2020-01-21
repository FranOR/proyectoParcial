package org.bedu.retrofitsalinas.presenter

import android.util.Log
import android.view.View
import android.widget.Toast
import org.bedu.retrofitsalinas.api.RetrofitService
import org.bedu.retrofitsalinas.model.IncidenciaRetrofit
import org.bedu.retrofitsalinas.model.Respuesta
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PresenterRetroIncidencia() {
    val parametro:String = "incidencia"
    private val api: RetrofitService = RetrofitService.create()
    fun crearIncidencias(incidencia: IncidenciaRetrofit){

        var callRespuesta = api.createIncidencia("/nuevaIncidencia",incidencia)

        callRespuesta.enqueue(object: Callback<Respuesta> {
            override fun onFailure(call: Call<Respuesta>, t: Throwable) {
                Log.d("Mensaje",t.toString())
            }

            override fun onResponse(call: Call<Respuesta>, response: Response<Respuesta>) {
                if (response.isSuccessful){
                   Log.d("Mensaje", response.body().toString())
                }
            }

        })
    }

}