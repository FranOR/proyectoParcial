package org.bedu.retrofitsalinas.api

import org.bedu.retrofitsalinas.model.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RetrofitService {

    @POST("{params}")
    fun register(@Path("params") params: String, @Body registration: Usuario): Call<loginResult>

    @POST("{param}")
    fun registerDate(@Path("param") param: String, @Body cita: Cita): Call<Respuesta>

    @POST("{param}")
    fun obtenerCitasPost(@Path("param") param: String, @Body cita: sendId): Call<List<Cita>>

    @POST("{param}")
    fun obtenerCitasPasadasPost(@Path("param") param: String, @Body cita: sendId): Call<List<Cita>>

    @GET("{param}/{param2}")
    fun obtenerCitas(@Path("param") param: String, @Path("param2") param2: String): Call<List<Cita>>

    @GET("{param}/{param2}")
    fun obtenerCitasPasadas(@Path("param") param: String, @Path("param2") param2: String): Call<List<Cita>>

    @POST("{param}")
    fun login(@Path("param") param: String, @Body login: loginSend): Call<loginResult>

    @GET("{params}")
    fun getInfoDoctor(@Path("params") params: String): Call<DoctorInfo>

    @POST("{param}")
    fun createIncidencia(@Path("param") param: String, @Body incidencia: IncidenciaRetrofit): Call<Respuesta>

    @GET("{params}")
    fun getInfoDoctores(@Path("params") params: String): Call<List<Doctor>>

    @POST("{params}")
    fun getInfoDoctor(@Path("params") params: String, @Body idDoctor: sendId): Call<Doctor>

    @GET("{params}")
    fun getAvisos(@Path("params") params: String): Call<List<Aviso>>

    @POST("{params}")
    fun createAviso(@Path("params") params: String, @Body aviso: Aviso): Call<String>

    @POST("{params}")
    fun getIncidencias(@Path("params") params: String,@Body id:sendId): Call<List<Incidencia>>

    @POST("{params}")
    fun changeStatus(@Path("params") params: String,@Body body:ChangeStatus): Call<Respuesta>
    @POST("{params}")
    fun getFechas(@Path("params") params: String, @Body idDoctor: sendId): Call<List<Fechas>>

    companion object Factory {
        fun create(): RetrofitService {
            var retrofit = Retrofit.Builder()
                .baseUrl("http://10.100.75.125:9097/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(RetrofitService::class.java)
        }
    }
}