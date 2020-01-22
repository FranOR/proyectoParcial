package org.bedu.retrofitsalinas.presenter

import android.util.Log
import org.bedu.retrofitsalinas.api.RetrofitService
import org.bedu.retrofitsalinas.model.Fechas
import org.bedu.retrofitsalinas.model.sendId
import org.bedu.retrofitsalinas.view.paciente.InfoDoctorView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FechasPresenter(var vista: InfoDoctorView) {
    private val api: RetrofitService = RetrofitService.create()
    fun obtenerFechas(id: sendId){

        var callResponse = api.getFechas("getFechas", id)

        callResponse.enqueue(object: Callback<List<Fechas>> {
            override fun onResponse(
                call: Call<List<Fechas>>,
                response: Response<List<Fechas>>
            ) {
                if(response.isSuccessful){
                    //vista.infoDoctor(response.body()!!)
                    var listaFechas = response.body() as List<Fechas>
                    vista.customAlert(listaFechas)
                    Log.d("Message", "${response.body()}")
                }
            }

            override fun onFailure(call: Call<List<Fechas>>, t: Throwable) {
                Log.d("MessageError", t.toString())
            }

        })

    }
}