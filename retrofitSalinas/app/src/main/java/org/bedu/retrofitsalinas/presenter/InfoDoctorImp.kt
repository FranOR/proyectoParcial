package com.bedu.proyectosalinas.presenter.paciente

import android.util.Log
import org.bedu.retrofitsalinas.api.RetrofitService
import org.bedu.retrofitsalinas.model.Doctor
import org.bedu.retrofitsalinas.model.sendId
import org.bedu.retrofitsalinas.view.paciente.InfoDoctorView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InfoDoctorImp(var vista: InfoDoctorView): InfoDoctor {

    private val api: RetrofitService = RetrofitService.create()

    override fun mostrarInfoDoctor(id: sendId){

        var callResponse = api.getInfoDoctor("getDoctors", id)

        callResponse.enqueue(object: Callback<Doctor> {
            override fun onResponse(
                call: Call<Doctor>,
                response: Response<Doctor>
            ) {
                if(response.isSuccessful){
                    vista.infoDoctor(response.body()!!)
                    Log.d("Message", "${response.body()}")
                }
            }

            override fun onFailure(call: Call<Doctor>, t: Throwable) {
                Log.d("MessageError", t.toString())
            }

        })

    }

}