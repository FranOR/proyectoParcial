package org.bedu.retrofitsalinas.presenter

import org.bedu.retrofitsalinas.model.Cita
import org.bedu.retrofitsalinas.model.sendId

interface DatesPresenter {

    fun crearCita(cita: Cita, ruta:String)

    fun obtenerCitas(id: String, ruta:String)

    fun obtenerCitasPasadas(id: String, ruta:String)

    fun obtenerCitasPost(id: sendId, ruta:String)

    fun obtenerCitasPasadasPost(id: sendId, ruta:String)
}