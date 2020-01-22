package org.bedu.retrofitsalinas.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Doctor(@SerializedName("nombre") var nombre: String,
    @SerializedName("id") var id: Int,
    @SerializedName("apellidos") var apellidos: String,
    @SerializedName("cedula") var cedula: String,
    @SerializedName("experiencia") var experiencia: String,
    @SerializedName("calificacion") var calificacion: Float,
    @SerializedName("score") var score: Int,
    @SerializedName("clinica") var clinica: String,
    @SerializedName("especialidad") var especialidad: String,
    @SerializedName("foto") var foto: String): Serializable
