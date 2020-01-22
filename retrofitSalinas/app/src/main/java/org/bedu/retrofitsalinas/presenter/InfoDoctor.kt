package com.bedu.proyectosalinas.presenter.paciente

import org.bedu.retrofitsalinas.model.Cita
import org.bedu.retrofitsalinas.model.sendId

interface InfoDoctor {
    fun mostrarInfoDoctor(id: sendId)
    fun registrarCita(cita: Cita)

}