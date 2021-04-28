package com.example.pruebagrupalkotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_te_negro.*
import kotlinx.android.synthetic.main.activity_te_verde.*
import kotlinx.android.synthetic.main.activity_te_verdecon_limon.*

class TeNegro : AppCompatActivity() {

    //val btnNegro = findViewById<Button>(R.id.button11)


         override fun onCreate(savedInstanceState: Bundle?) {
             super.onCreate(savedInstanceState)
             setContentView(R.layout.activity_te_negro)
             button3.setOnClickListener {
                 val intent: Intent = Intent(this@TeNegro, Comentario::class.java)
                 startActivity(intent);

             }

             }
         }









