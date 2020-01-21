package org.bedu.retrofitsalinas.model

import com.google.gson.annotations.SerializedName

data class loginSend(
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String
)