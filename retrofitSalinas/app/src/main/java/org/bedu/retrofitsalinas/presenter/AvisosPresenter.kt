package org.bedu.retrofitsalinas.presenter

import org.bedu.retrofitsalinas.model.Aviso

interface AvisosPresenter {

    fun obtenerAvisos(ruta:String){}
    fun crearAviso(ruta: String,aviso: Aviso){

    }

}