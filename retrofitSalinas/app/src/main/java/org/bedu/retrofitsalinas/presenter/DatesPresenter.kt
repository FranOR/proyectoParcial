package org.bedu.retrofitsalinas.presenter

import org.bedu.retrofitsalinas.model.Cita

interface DatesPresenter {

    fun crearCita(cita: Cita, ruta:String)

    fun obtenerCitas(id: String, ruta:String)

    fun obtenerCitasPasadas(id: String, ruta:String)
}