package org.bedu.retrofitsalinas.model

import com.google.gson.annotations.SerializedName

class Incidencia (@SerializedName("id") var folio: Int,
                  @SerializedName("titulo") var titulo: String,
                  @SerializedName("fecha") var fecha: String,
                  @SerializedName("categoria") var categoria: String,
                  @SerializedName("descripcion") var desripcion: String,
                  @SerializedName("estado") var estado: Int)