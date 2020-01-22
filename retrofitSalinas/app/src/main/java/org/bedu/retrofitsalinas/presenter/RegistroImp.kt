package com.bedu.proyectosalinas.presenter

import android.util.Log
import org.bedu.retrofitsalinas.api.RetrofitService
import org.bedu.retrofitsalinas.model.Usuario
import org.bedu.retrofitsalinas.model.loginResult
import org.bedu.retrofitsalinas.view.RegistroView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistroImp(var vista: RegistroView): Registro {


    private val api: RetrofitService = RetrofitService.create()

    override fun sendRegistro(datos: Usuario): Boolean {
        var callResponse = api.register("register", datos)

        callResponse.enqueue(object: Callback<loginResult> {
            override fun onResponse(
                call: Call<loginResult>,
                response: Response<loginResult>
            ) {
                if(response.isSuccessful){
                    Log.d("Message", "${response.body()}")
                    vista.getRegisterResponse("Login Correcto")
                }
            }

            override fun onFailure(call: Call<loginResult>, t: Throwable) {
                vista.getRegisterResponse("Correo o contraseña inválidos")
            }

        })
        return true
    }

}