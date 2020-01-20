package org.bedu.retrofitsalinas.presenter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.bedu.retrofitsalinas.R
import org.bedu.retrofitsalinas.view.LoginView

class LoginActivity : AppCompatActivity(), LoginView {

    val presenter = LoginImp(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_blank)

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
            val intento = Intent(this,RegistroActivity::class.java)
            startActivity(intento)
        }
    }

    override fun getLoginResponse(answer: String) {
        Toast.makeText(this, answer, Toast.LENGTH_LONG).show()
    }

    override fun getLoginData(id: Int, isDoctor: Boolean) {
        if (id > 0) {
            //SE AGREGA FUNCION PARA ALMACENAR EL ID EN SHAREDPREFERENCES
            if (isDoctor) {
                //SE MANDA A LA ACTIVIDAD DE LOS DOCTORES
                Log.d("Mensaje","Se inicio sesion como un Doctor")
                val intento = Intent(this,HomeEmpresarialActivity::class.java)
                startActivity(intento)
            } else if (!isDoctor) {
                //SE MANDA A LA ACTIVIDAD DE USUARIOS
                Log.d("Mensaje","Se inicio sesion como un Usuario")
                val intento = Intent(this,InfoDoctorActivity::class.java)
                startActivity(intento)

            }
        }
    }


}
