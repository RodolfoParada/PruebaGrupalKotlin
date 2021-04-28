package com.example.pruebagrupalkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_te_negro.*
import kotlinx.android.synthetic.main.activity_te_verde.*

class TeVerde : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_te_verde)

        button11.setOnClickListener {
            val intent: Intent = Intent(this@TeVerde, Comentario::class.java)
            startActivity(intent);
        }

    }
    }
