package com.example.pruebagrupalkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_te_verdecon_limon.*
import kotlinx.android.synthetic.main.activity_tede_jengibre.*

class TedeJengibre : AppCompatActivity() {
   // val btnJengibre = findViewById<Button>(R.id.button5)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tede_jengibre)

       button5.setOnClickListener {
           val intent: Intent = Intent(this@TedeJengibre, Comentario::class.java)
           startActivity(intent);
       }
    }
}