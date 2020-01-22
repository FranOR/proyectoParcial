package org.bedu.retrofitsalinas.model

import com.google.gson.annotations.SerializedName

data class Usuario (@SerializedName("id") var id: Int,
                    @SerializedName("userId") var userId: Int,
                    @SerializedName("nombre") var nombre: String,
                    @SerializedName("telefono") var telefono: String,
                    @SerializedName("email") var email: String,
                    @SerializedName("password") var password: String,
                    @SerializedName("ine") var ine: String)