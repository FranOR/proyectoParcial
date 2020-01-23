package org.bedu.retrofitsalinas.presenter

import android.util.Log
import org.bedu.retrofitsalinas.api.RetrofitService
import org.bedu.retrofitsalinas.model.Cita
import org.bedu.retrofitsalinas.model.Response
import org.bedu.retrofitsalinas.model.Respuesta
import org.bedu.retrofitsalinas.model.sendId
import org.bedu.retrofitsalinas.view.paciente.DatesView
import org.bedu.retrofitsalinas.view.doctor.MainView
import retrofit2.Call
import retrofit2.Callback

class DatesPresenterImp() : DatesPresenter {
    override fun obtenerCitas(id: String, ruta: String) {

    }

    override fun obtenerCitasPasadas(id: String, ruta: String) {

    }

    private val api: RetrofitService = RetrofitService.create()
    private lateinit var vista: MainView
    private lateinit var vista2: DatesView

    constructor(vista: MainView) : this() {
        this.vista = vista
    }

    constructor(vista2: DatesView) : this() {
        this.vista2 = vista2
    }

    override fun crearCita(cita: Cita, ruta: String) {
        val request = api.registerDate(ruta, cita)
        request.enqueue(object: Callback<Respuesta> {
            override fun onFailure(call: Call<Respuesta>, t: Throwable) {
                Log.d("Mensaje",t.toString())
            }
            override fun onResponse(call: Call<Respuesta>, response: retrofit2.Response<Respuesta>) {
                if (response.isSuccessful){

                }
            }
        })
    }

    override fun obtenerCitasPost(id: sendId, ruta: String) {
        val request = api.obtenerCitasPost(ruta, id)
        request.enqueue(object: Callback<List<Cita>> {
            override fun onFailure(call: Call<List<Cita>>, t: Throwable) {
                Log.d("Mensaje",t.toString())
            }
            override fun onResponse(call: Call<List<Cita>>, response: retrofit2.Response<List<Cita>>) {
                if (response.isSuccessful){
                    var listaCitas = response.body() as ArrayList<Cita>
                    vista2.llenarRecycler(listaCitas)
                }
            }
        })
    }

    override fun obtenerCitasPasadasPost(id: sendId, ruta: String) {
        val request = api.obtenerCitasPasadasPost(ruta, id)
        request.enqueue(object: Callback<List<Cita>> {
            override fun onFailure(call: Call<List<Cita>>, t: Throwable) {
                Log.d("Mensaje",t.toString())
            }
            override fun onResponse(call: Call<List<Cita>>, response: retrofit2.Response<List<Cita>>) {
                if (response.isSuccessful){
                    var listaCitas = response.body() as ArrayList<Cita>
                    vista2.llenarRecyclerPasadas(listaCitas)
                }
            }
        })
    }
}