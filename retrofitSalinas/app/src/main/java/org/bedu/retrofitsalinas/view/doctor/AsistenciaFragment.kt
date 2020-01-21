package com.bedu.proyectosalinas.view.doctor


import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.asistenciafragment.*
import org.bedu.retrofitsalinas.R


class AsistenciaFragment : Fragment() {
    //lateinit var serviciosIncidencia: ServiciosIncidencia
    lateinit var vista: View
    val CAMERA_REQUEST_CODE = 0
    val PERMISSION_CODE = 1000
    lateinit var currentPhotoPath: String
    var image_uri: Uri? = null
    private val IMAGE_CAPTURE_CODE = 1001
    var REQUEST_IMAGE_CAPTURE = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.asistenciafragment, container, false)



        return vista
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonAsistencia.setOnClickListener {
            //if system os is Marshmallow or Above, we need to request runtime permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(vista.context, Manifest.permission.CAMERA)
                    == PackageManager.PERMISSION_DENIED ||
                    ContextCompat.checkSelfPermission(
                        vista.context,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    )
                    == PackageManager.PERMISSION_DENIED
                ) {
                    //permission was not enabled
                    val permission = arrayOf(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    )
                    //show popup to request permission
                    requestPermissions(permission, PERMISSION_CODE)
                } else {
                    //permission already granted
                    openCamera()
                }
            } else {
                //system os is < marshmallow
                openCamera()
            }


        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //called when image was captured from camera intent
        if (resultCode == Activity.RESULT_OK) {
            if (data != null) {
                val imageBitmap = data.extras!!.get("data") as Bitmap
                photoimageView.setImageBitmap(imageBitmap)
            } else {

            }
            //Toast.makeText(vista.context, "DATA: $data", Toast.LENGTH_SHORT).show()
            //set image captured to image view
            //photoimageView.setImageURI(image_uri)
        }
    }

    private fun openCamera() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "New Picture")
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera")
        image_uri = vista.context.contentResolver.insert(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            values
        )


        //camera intent
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(vista.context.packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
        //val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        //cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri)
        //startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        //called when user presses ALLOW or DENY from Permission Request Popup
        when (requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                    //permission from popup was granted
                    openCamera()
                } else {
                    //permission from popup was denied
                    Toast.makeText(vista.context, "Permiso Denegado", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}