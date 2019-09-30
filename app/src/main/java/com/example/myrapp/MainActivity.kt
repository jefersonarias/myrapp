package com.example.myrapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        twel.text = "Bienvenidos a MyRapp 2.0. App de prueba"
        textdesc.text = "La app compila perfectamente, pero tuve demasiadas dificultades con el parseo de la info Json y otros pormenores. (learning) "
        binicio.text = "INICIAR"

        binicio.setOnClickListener {

            var intent = Intent(this, EjectActivity::class.java)
            startActivity(intent)

        }

    }
}
