package org.bedu.retrofitsalinas.model

import com.google.gson.annotations.SerializedName

class Fechas (@SerializedName("id") var id:Int,
    @SerializedName("fecha") var fecha:String,
    @SerializedName("idDoctor") var idDoctor:Int,
    @SerializedName("disponible") var disponible:Boolean)
