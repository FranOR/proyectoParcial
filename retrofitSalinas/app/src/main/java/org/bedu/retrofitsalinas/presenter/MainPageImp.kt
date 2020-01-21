package org.bedu.retrofitsalinas.presenter

import android.util.Log
import org.bedu.retrofitsalinas.api.RetrofitService
import org.bedu.retrofitsalinas.model.Doctor
import org.bedu.retrofitsalinas.model.DoctorInfo
import org.bedu.retrofitsalinas.view.paciente.InfoDoctorView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPageImp(var vista: InfoDoctorView): MainPage  {
    override fun mostrarInfoDoctor(id: String){

        lateinit var nombreDoctor: String
        lateinit var doctor: DoctorInfo
        val api: RetrofitService = RetrofitService.create()

        var callResponse = api.getInfoDoctor(id)

        nombreDoctor = ""

        callResponse.enqueue(object: Callback<DoctorInfo> {
            override fun onResponse(
                call: Call<DoctorInfo>,
                response: Response<DoctorInfo>
            ) {
                if(response.isSuccessful){
                    nombreDoctor = response.body()!!.nombre
                    doctor = response.body()!!
                    //vista.infoDoctor(nombreDoctor)
                    Log.d("Message", "${response.body()}")
                }
            }

            override fun onFailure(call: Call<DoctorInfo>, t: Throwable) {
                Log.d("MessageError", t.toString())
            }

        })

    }

}