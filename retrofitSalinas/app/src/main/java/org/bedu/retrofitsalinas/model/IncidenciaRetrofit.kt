package org.bedu.retrofitsalinas.model

import com.google.gson.annotations.SerializedName

class IncidenciaRetrofit(@SerializedName("id") var rfolio: Int,
                         @SerializedName("titulo") var rtitulo: String,
                         @SerializedName("fecha") var rfecha: String,
                         @SerializedName("categoria") var rcategoria: String,
                         @SerializedName("descripcion") var rdescripcion: String,
                         @SerializedName("idDoctor") var rempleado: Int) {
}