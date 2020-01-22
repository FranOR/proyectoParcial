package org.bedu.retrofitsalinas.model

import com.google.gson.annotations.SerializedName

class Aviso(@SerializedName("id") var id: Int,
            @SerializedName("fecha") var fecha: String,
            @SerializedName("titulo") var titulo: String,
            @SerializedName("descripcion") var descripcion: String
            )