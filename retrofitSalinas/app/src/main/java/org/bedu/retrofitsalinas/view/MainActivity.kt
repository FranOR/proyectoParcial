package org.bedu.retrofitsalinas.view

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.bedu.retrofitsalinas.R
import org.bedu.retrofitsalinas.model.Cita
import org.bedu.retrofitsalinas.presenter.DatesPresenterImp

class MainActivity : AppCompatActivity(), MainView {

    lateinit var shared:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shared = getSharedPreferences("user", Context.MODE_PRIVATE)

        var editor:SharedPreferences.Editor = shared.edit()
        editor.putString("idUsuario","1")
        editor.apply()
        setByDefault()
    }

    private fun setByDefault() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, DatesFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun obtenerUserId():String {
        return shared.getString("idUsuario", "0").toString()
    }


}
