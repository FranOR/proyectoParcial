package org.bedu.retrofitsalinas.view.paciente

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.bedu.proyectosalinas.view.paciente.ListaDoctorFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main_cliente.*
import org.bedu.retrofitsalinas.R
import org.bedu.retrofitsalinas.model.Doctor
import org.bedu.retrofitsalinas.model.Fechas
import org.bedu.retrofitsalinas.presenter.MainPageImp

class InfoDoctorActivity : AppCompatActivity(), InfoDoctorView {
    override fun mostrarToast(mensaje: String) {
        //N/A
    }

    override fun customAlert(listaFechas: List<Fechas>) {
        //N/A
    }


    val presenter = MainPageImp(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_cliente)

        //presenter.mostrarInfoDoctor("2")
        var reqFragment = getIntent().getStringExtra("request")
        setupNavigation(bottom_navigation,reqFragment!!)
    }

    override fun infoDoctor(doctor: Doctor) {
        //Log.d("Message", doctor.toString())
    }

    override fun onBackPressed() {
        super.onBackPressed()

        val intento = Intent(this, HomePacienteActivity::class.java)
        startActivity(intento)
    }
    private fun setupNavigation(navigationBar: BottomNavigationView, reqFragment:String) {

        navigationBar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.doctores -> {
                    val fragment =
                        ListaDoctorFragment()
                    openFragment(fragment)
                    true
                }
                R.id.citas -> {
                    val fragment =
                        DatesFragment()
                    openFragment(fragment)
                    true
                }
                R.id.clinicas -> {
                    val fragment =
                        ListaDoctorFragment()
                    openFragment(fragment)
                    true
                }
                R.id.configuracion -> {
                    val fragment =
                        ListaDoctorFragment()
                    openFragment(fragment)
                    true
                }
                else -> false
            }
        }

        when(reqFragment){
            "doctores" ->{
                navigationBar.selectedItemId = R.id.doctores
            }

            "citas" ->{
                navigationBar.selectedItemId = R.id.citas
            }

            "clinicas" ->{
                navigationBar.selectedItemId = R.id.clinicas
            }

            "configuracion" ->{
                navigationBar.selectedItemId = R.id.configuracion
            }
            else ->
                navigationBar.selectedItemId = R.id.doctores
        }

    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment1, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}
