package org.bedu.retrofitsalinas.presenter

import android.util.Log
import org.bedu.retrofitsalinas.api.RetrofitService
import org.bedu.retrofitsalinas.model.Aviso
import org.bedu.retrofitsalinas.model.ChangeStatus
import org.bedu.retrofitsalinas.model.Incidencia
import org.bedu.retrofitsalinas.model.sendId
import org.bedu.retrofitsalinas.view.doctor.IncidenciasView
import retrofit2.Call
import retrofit2.Callback

class IncidenciasPresenterImp(var view: IncidenciasView) :IncidenciasPresenter{
    override fun cambiarEstado(ruta: String, body: ChangeStatus) {

    }

    private val api = RetrofitService.create()

    override fun obtenerIncidencias(ruta: String,id:sendId) {
        val request = api.getIncidencias(ruta,id)
        request.enqueue(object: Callback<List<Incidencia>> {
            override fun onFailure(call: Call<List<Incidencia>>, t: Throwable) {
                Log.d("Mensaje",t.toString())
            }
            override fun onResponse(call: Call<List<Incidencia>>, response: retrofit2.Response<List<Incidencia>>) {
                if (response.isSuccessful){
                    var listaIncidencia = response.body() as List<Incidencia>
                    view.mostrarIncidencias(listaIncidencia)
                }
            }
        })
    }


}