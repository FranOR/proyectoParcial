package org.bedu.retrofitsalinas.view

import androidx.recyclerview.widget.RecyclerView
import org.bedu.retrofitsalinas.model.Cita

interface DatesView {

    fun obtenerUserId():String

    fun llenarRecycler(listaCitas:List<Cita>)

    fun llenarRecyclerPasadas(listaCitas:List<Cita>)

}