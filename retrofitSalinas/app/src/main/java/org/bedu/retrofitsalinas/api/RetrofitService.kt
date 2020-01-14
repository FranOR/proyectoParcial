package org.bedu.retrofitsalinas.api

import org.bedu.retrofitsalinas.model.Cita
import org.bedu.retrofitsalinas.model.Response
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RetrofitService {

    @POST("{param}")
    fun registerDate(@Path("param") param: String, @Body cita: Cita): Call<Response>

    @GET("{param}/{param2}")
    fun obtenerCitas(@Path("param") param: String, @Path("param2") param2: String): Call<List<Cita>>

    @GET("{param}/{param2}")
    fun obtenerCitasPasadas(@Path("param") param: String, @Path("param2") param2: String): Call<List<Cita>>

    companion object Factory {
        fun create(): RetrofitService {
            var retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.100.48:9097/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(RetrofitService::class.java)
        }
    }
}