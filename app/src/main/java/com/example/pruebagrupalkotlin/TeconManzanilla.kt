package com.example.pruebagrupalkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_tecon_manzanilla.*
import kotlinx.android.synthetic.main.activity_tecon_menta.*

class TeconManzanilla : AppCompatActivity() {
   // val btnManzanilla = findViewById<Button>(R.id.button8)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tecon_manzanilla)

       button8.setOnClickListener {
           val intent: Intent = Intent(this@TeconManzanilla, Comentario::class.java)
           startActivity(intent);
       }
    }
}