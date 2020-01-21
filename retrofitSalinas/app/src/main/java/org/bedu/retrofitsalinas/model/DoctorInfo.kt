package org.bedu.retrofitsalinas.model

import com.google.gson.annotations.SerializedName

data class DoctorInfo(
    @SerializedName("nombre") var nombre: String,
    @SerializedName("id") var id: Int,
    @SerializedName("apellidos") var apellidos: String,
    @SerializedName("cedula") var cedula: String,
    @SerializedName("experiencia") var experiencia: String,
    @SerializedName("calificacion") var calificacion: String,
    @SerializedName("clinica") var clinica: String,
    @SerializedName("foto") var foto: String
)