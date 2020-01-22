package com.bedu.proyectosalinas.presenter

import org.bedu.retrofitsalinas.model.Usuario

interface Registro {
    fun sendRegistro(datos: Usuario): Boolean
}