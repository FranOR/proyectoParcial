package org.bedu.retrofitsalinas.view.paciente

import org.bedu.retrofitsalinas.model.Doctor
import org.bedu.retrofitsalinas.model.Fechas

interface InfoDoctorView {
    fun infoDoctor(doctor: Doctor)
    fun customAlert(listaFechas: List<Fechas>)
    fun mostrarToast(mensaje:String)

}