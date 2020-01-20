package org.bedu.retrofitsalinas.view

import androidx.recyclerview.widget.RecyclerView
import org.bedu.retrofitsalinas.model.Cita
import org.bedu.retrofitsalinas.model.sendId

interface DatesView {

    fun obtenerUserId():sendId

    fun llenarRecycler(listaCitas:List<Cita>)

    fun llenarRecyclerPasadas(listaCitas:List<Cita>)

}