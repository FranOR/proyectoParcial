package org.bedu.retrofitsalinas.presenter

import android.util.Log
import org.bedu.retrofitsalinas.api.RetrofitService
import org.bedu.retrofitsalinas.model.loginResult
import org.bedu.retrofitsalinas.model.loginSend
import org.bedu.retrofitsalinas.view.LoginView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginImp(var vista: LoginView) : Login {

    private val api: RetrofitService = RetrofitService.create()

    override fun sendLogin(login:loginSend){
        var callResponse = api.login("login",login)
        callResponse.enqueue(object: Callback<loginResult> {
            override fun onResponse(call: Call<loginResult>, response: Response<loginResult>) {
                if(response.isSuccessful){
                    Log.d("Message", "${response.body()}")
                    vista.getLoginResponse("Login Correcto")
                    var id = response.body()!!.id
                    var isDoctor = response.body()!!.isDoctor
                    vista.getLoginData(id, isDoctor)
                }
            }
            override fun onFailure(call: Call<loginResult>, t: Throwable) {
                vista.getLoginResponse("Correo o contraseña inválidos")
            }
        })
    }
}