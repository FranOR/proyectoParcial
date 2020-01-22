package org.bedu.retrofitsalinas.view.doctor

import org.bedu.retrofitsalinas.model.Aviso

interface AvisosView {

    fun mostrarAvisos(listAviso:List<Aviso>)
    fun avisoCreado(respuesta:String)
}