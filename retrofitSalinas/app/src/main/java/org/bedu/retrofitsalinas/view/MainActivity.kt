package org.bedu.retrofitsalinas.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bedu.proyectosalinas.view.doctor.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import org.bedu.retrofitsalinas.R
import org.bedu.retrofitsalinas.view.doctor.HomeEmpresarialActivity

class MainActivity : AppCompatActivity() {

    //lateinit var serviciosIncidencia: ServiciosIncidencia
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var reqFragment = getIntent().getStringExtra("request")

        setupNavigation(bottom_navigation,reqFragment)


    }

    override fun onBackPressed() {
        super.onBackPressed()

        val intento = Intent(this, HomeEmpresarialActivity::class.java)
        startActivity(intento)
    }
    private fun setupNavigation(navigationBar: BottomNavigationView, reqFragment:String) {

        navigationBar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navAsistencia -> {

                    val fragment =
                        AsistenciaFragment()
                    openFragment(fragment)
                    true
                }
                R.id.navIncidencias -> {
                    val fragment =
                        IncidenciasFragment()
                    openFragment(fragment)
                    true
                }
                R.id.navAvisos -> {
                    val fragment =
                        AvisosFragment()
                    openFragment(fragment)
                    true
                }
                else -> false
            }
        }

        when(reqFragment){
            "asistencia" ->{
                navigationBar.selectedItemId = R.id.navAsistencia
            }

            "avisos" ->{
                navigationBar.selectedItemId = R.id.navAvisos
            }

            "incidencias" ->{
                navigationBar.selectedItemId = R.id.navIncidencias
            }

            "configuracion" ->{
                navigationBar.selectedItemId = R.id.navAvisos
            }
            else ->
                navigationBar.selectedItemId = R.id.navAsistencia
        }

    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
