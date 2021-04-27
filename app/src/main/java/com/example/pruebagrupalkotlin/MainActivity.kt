package com.example.pruebagrupalkotlin


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var Vista : RecyclerView
    val adaptador : RecyclerAdapter = RecyclerAdapter()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
    }

    fun getTiposDiferentesTe(): MutableList<VariedadesTe> {
        var tiposdiferenteste: MutableList<VariedadesTe> = ArrayList()
        tiposdiferenteste.add(VariedadesTe("Té Verde",  "https://i.pinimg.com/564x/53/8e/86/538e86392562f6fadc122903485bbe5c.jpg"))
        tiposdiferenteste.add(VariedadesTe("Té Negro", "https://i.pinimg.com/564x/27/5f/f6/275ff67e5022b565f8b992ca1a7d7eb1.jpg" ))
        tiposdiferenteste.add(VariedadesTe("Té Verde con Limón", "https://i.pinimg.com/564x/ee/73/92/ee7392d93bacad1a200ddd4a85568687.jpg"))
        tiposdiferenteste.add(VariedadesTe("Té de Jengibre", "https://i.pinimg.com/564x/1e/e5/1c/1ee51ca619dd8c17efebd8f37ca9332e.jpg"))
        tiposdiferenteste.add(VariedadesTe("Té con Miel", "https://i.pinimg.com/564x/bd/35/5a/bd355aa46d0cec2c2d492afc3f8b800f.jpg"))
        tiposdiferenteste.add(VariedadesTe("Té con Canela", "https://i.pinimg.com/564x/0b/bd/e0/0bbde007b2abef5b3544091869a0d95c.jpg"))
        tiposdiferenteste.add(VariedadesTe("Té con Manzanilla", "https://i.pinimg.com/564x/97/28/1a/97281a7f8cb1954d493ea216f8796413.jpg"))
        tiposdiferenteste.add(VariedadesTe("Té de Menta", "https://i.pinimg.com/564x/d6/99/4f/d6994f857ffc25d52887ac25f5069a16.jpg"))
        return tiposdiferenteste
    }
    fun setUpRecyclerView(){
        Vista = findViewById(R.id.variedades_te) as RecyclerView
        Vista.setHasFixedSize(true)
        Vista.layoutManager = LinearLayoutManager(this)
        adaptador.RecyclerAdapter(getTiposDiferentesTe(), this)
        Vista.adapter = adaptador
    }

}
