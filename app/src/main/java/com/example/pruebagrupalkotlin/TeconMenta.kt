package com.example.pruebagrupalkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_tecon_menta.*
import kotlinx.android.synthetic.main.activity_tede_jengibre.*

class TeconMenta : AppCompatActivity() {
   // val btnMenta = findViewById<Button>(R.id.button7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tecon_menta)

            button7.setOnClickListener {
           val intent: Intent = Intent(this@TeconMenta, Comentario::class.java)
           startActivity(intent);
       }
    }
}