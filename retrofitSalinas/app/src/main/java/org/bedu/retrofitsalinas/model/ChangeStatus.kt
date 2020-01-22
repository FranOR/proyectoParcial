package org.bedu.retrofitsalinas.model

import com.google.gson.annotations.SerializedName

data class ChangeStatus(
    @SerializedName("id") var id: Int,
    @SerializedName("estatus") var status: Int)