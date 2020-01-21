package com.bedu.proyectosalinas.view.doctor

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.bedu.retrofitsalinas.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AvisosFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 */
class AvisosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_avisos, container, false)
    }




}
