package org.bedu.retrofitsalinas.model

import com.google.gson.annotations.SerializedName

data class Cita(
    @SerializedName("id") var id: Int,
    @SerializedName("fecha") var fecha: String,
    @SerializedName("idDoctor") var idDoctor: Int,
    @SerializedName("idUsuario") var idPaciente: Int,
    @SerializedName("nombre") var nombreDoctor: String,
    @SerializedName("asunto") var asunto: String,
    @SerializedName("calificacion") var calificacion: Float,
    @SerializedName("clinica") var clinica: String)
