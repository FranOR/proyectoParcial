package com.bedu.proyectosalinas.presenter.paciente

import android.util.Log
import com.bedu.proyectosalinas.view.paciente.ListaDoctorView
import org.bedu.retrofitsalinas.api.RetrofitService
import org.bedu.retrofitsalinas.model.Doctor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaDoctorImp(var vista: ListaDoctorView): ListaDoctor {

    private val api: RetrofitService = RetrofitService.create()

    override fun mostrarDoctores() {

        var callResponse = api.getInfoDoctores("/getDoctors")

        callResponse.enqueue(object: Callback<List<Doctor>> {
            override fun onResponse(
                call: Call<List<Doctor>>,
                response: Response<List<Doctor>>
            ) {
                if(response.isSuccessful){
                    var listaDoctores = response.body() as ArrayList<Doctor>
                    vista.llenarRecycler(listaDoctores)
                    Log.d("Message", "${response.body()}")
                }
            }
            override fun onFailure(call: Call<List<Doctor>>, t: Throwable) {
                Log.d("MessageError", t.toString())
            }

        })
    }
}