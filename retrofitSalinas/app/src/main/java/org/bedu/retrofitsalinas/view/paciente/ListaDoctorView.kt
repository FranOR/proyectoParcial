package com.bedu.proyectosalinas.view.paciente

import org.bedu.retrofitsalinas.model.Doctor

interface ListaDoctorView {
    fun llenarRecycler(listaDoctores:List<Doctor>)
}