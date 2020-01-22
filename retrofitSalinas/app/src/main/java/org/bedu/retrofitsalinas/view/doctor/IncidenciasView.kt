package org.bedu.retrofitsalinas.view.doctor

import org.bedu.retrofitsalinas.model.Incidencia
import org.bedu.retrofitsalinas.model.Respuesta

interface IncidenciasView {

    fun mostrarIncidencias(listIncidencias:List<Incidencia>)
    fun refrescarLista(respuesta: Respuesta)
}