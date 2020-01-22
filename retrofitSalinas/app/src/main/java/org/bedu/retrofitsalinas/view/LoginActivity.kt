package org.bedu.retrofitsalinas.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import org.bedu.retrofitsalinas.R
import org.bedu.retrofitsalinas.model.loginSend
import org.bedu.retrofitsalinas.presenter.LoginImp
import org.bedu.retrofitsalinas.view.doctor.HomeEmpresarialActivity
import org.bedu.retrofitsalinas.view.paciente.HomePacienteActivity
import org.bedu.retrofitsalinas.view.paciente.InfoDoctorActivity

class LoginActivity : AppCompatActivity(), LoginView {

    val presenter = LoginImp(this)
    val PREFS_NAME = "sharedpreferences"
    val ID = "ID"
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login.setOnClickListener {
            var email = usernameEdit.text.toString()
            var password = passwordEdit.text.toString()
            Log.d("Mensaje","Parametros: $email - $password")
            var user = loginSend(email,password)
            presenter.sendLogin(user)
            //val intento = Intent(this,HomeEmpresarialActivity::class.java)
            //startActivity(intento)
        }

        register.setOnClickListener {
            val intento = Intent(this, RegistroActivity::class.java)
            startActivity(intento)
        }
    }

    override fun getLoginResponse(answer: String) {
        Toast.makeText(this, answer, Toast.LENGTH_LONG).show()
    }

    override fun getLoginData(id: Int, isDoctor: Boolean) {
        if (id > 0) {
            preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            preferences.edit()
                .putInt(ID, id)
                .commit()
            //SE AGREGA FUNCION PARA ALMACENAR EL ID EN SHAREDPREFERENCES
            if (isDoctor) {
                //SE MANDA A LA ACTIVIDAD DE LOS DOCTORES
                Log.d("Mensaje","Se inicio sesion como un Doctor")
                val intento = Intent(this, HomeEmpresarialActivity::class.java)
                startActivity(intento)
            } else if (!isDoctor) {
                //SE MANDA A LA ACTIVIDAD DE USUARIOS
                Log.d("Mensaje","Se inicio sesion como un Usuario")
                val intento = Intent(this, HomePacienteActivity::class.java)
                startActivity(intento)
            }
        }
    }


}
