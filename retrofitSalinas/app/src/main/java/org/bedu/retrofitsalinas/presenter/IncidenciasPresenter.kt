package org.bedu.retrofitsalinas.presenter

import org.bedu.retrofitsalinas.model.ChangeStatus
import org.bedu.retrofitsalinas.model.sendId

interface IncidenciasPresenter {

    fun obtenerIncidencias(ruta:String,id:sendId)

    fun cambiarEstado(ruta: String,body:ChangeStatus)
}