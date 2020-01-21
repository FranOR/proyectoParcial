package org.bedu.retrofitsalinas.model

import com.google.gson.annotations.SerializedName

data class loginResult(
    @SerializedName("isDoctor") var isDoctor: Boolean,
    @SerializedName("id") var id: Int
)