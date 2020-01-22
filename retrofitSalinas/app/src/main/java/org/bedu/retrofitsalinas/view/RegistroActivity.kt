package org.bedu.retrofitsalinas.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bedu.proyectosalinas.presenter.RegistroImp
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator
import kotlinx.android.synthetic.main.activity_registro.*
import org.bedu.retrofitsalinas.R
import org.bedu.retrofitsalinas.model.Usuario

class RegistroActivity : AppCompatActivity(), RegistroView {
    override fun getRegisterResponse(answer: String) {
        Toast.makeText(this, answer, Toast.LENGTH_LONG).show()
    }

    val presenter = RegistroImp(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)



        login.setOnClickListener {

            var emailOut = email.text.toString()
            var passwordOut = pwd.text.toString()
            var nombreOut = nombreCompleto.text.toString()
            var telefonoOut = telefono.text.toString()

            var isValid = false

            emailOut.validator()
                .validEmail()
                .nonEmpty()
                .addErrorCallback {
                    isValid = false
                    emailBox.boxStrokeColor = Color.parseColor("#FF0000")
                    email.setTextColor(Color.parseColor("#FF0000"))
                }
                .addSuccessCallback {
                    emailBox.boxStrokeColor = Color.parseColor("#000000")
                    email.setTextColor(Color.parseColor("#000000"))
                    isValid = true
                }
                .check()

            passwordOut.validator()
                .nonEmpty()
                .minLength(8)
                .addErrorCallback {
                    username.boxStrokeColor = Color.parseColor("#FF0000")
                    pwd.setTextColor(Color.parseColor("#FF0000"))
                    isValid = false
                }
                .addSuccessCallback {
                    username.boxStrokeColor = Color.parseColor("#000000")
                    pwd.setTextColor(Color.parseColor("#000000"))
                    isValid = true
                }
                .check()

            nombreOut.validator()
                .nonEmpty()
                .noNumbers()
                .addErrorCallback {
                    isValid = false
                    username.boxStrokeColor = Color.parseColor("#FF0000")
                    nombreCompleto.setTextColor(Color.parseColor("#FF0000"))
                }
                .addSuccessCallback {
                    username.boxStrokeColor = Color.parseColor("#000000")
                    nombreCompleto.setTextColor(Color.parseColor("#000000"))
                    isValid = true
                }
                .check()

            telefonoOut.validator()
                .nonEmpty()
                .addErrorCallback {
                    isValid = false
                    username1.boxStrokeColor = Color.parseColor("#FF0000")
                    telefono.setTextColor(Color.parseColor("#FF0000"))
                }
                .addSuccessCallback {
                    username1.boxStrokeColor = Color.parseColor("#000000")
                    telefono.setTextColor(Color.parseColor("#000000"))
                    isValid = true
                }
                .check()

            if(isValid) {
                var registerData =  Usuario(1, 1, nombreOut, telefonoOut, emailOut, passwordOut, "123.png")
                presenter.sendRegistro(registerData)
            }
        }
    }
}
