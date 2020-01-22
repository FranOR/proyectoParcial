package org.bedu.retrofitsalinas.presenter

import android.util.Log
import com.bedu.proyectosalinas.view.doctor.AvisosFragment
import com.bedu.proyectosalinas.view.doctor.IncidenciasFragment
import org.bedu.retrofitsalinas.api.RetrofitService
import org.bedu.retrofitsalinas.model.Aviso
import retrofit2.Call
import retrofit2.Callback

class AvisosPresenterImp(var view: AvisosFragment):AvisosPresenter {

    private val api = RetrofitService.create()
    override fun obtenerAvisos(ruta:String){

        val request = api.getAvisos(ruta)
        request.enqueue(object: Callback<List<Aviso>> {
            override fun onFailure(call: Call<List<Aviso>>, t: Throwable) {
                Log.d("Mensaje",t.toString())
            }
            override fun onResponse(call: Call<List<Aviso>>, response: retrofit2.Response<List<Aviso>>) {
                if (response.isSuccessful){
                    var listaAvisos = response.body() as List<Aviso>
                    view.mostrarAvisos(listaAvisos)
                }
            }
        })
    }

    override fun crearAviso(ruta: String,aviso:Aviso) {

        val request = api.createAviso(ruta,aviso)
        request.enqueue(object: Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("Mensaje",t.toString())
            }
            override fun onResponse(call: Call<String>, response: retrofit2.Response<String>) {
                if (response.isSuccessful){
                    var respuesta = response.body() as String
                    view.avisoCreado(respuesta)
                }
            }
        })
    }
}