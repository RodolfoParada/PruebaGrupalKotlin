package com.example.pruebagrupalkotlin

import android.accounts.AccountManager.get
import android.content.Context
import android.content.Intent
import android.nfc.tech.MifareClassic.get
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.lang.reflect.Array.get
import java.nio.file.Paths.get


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var Tiposte: MutableList<VariedadesTe> = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter(TiposDiferentesTe: MutableList<VariedadesTe>, context: Context) {
        this.Tiposte = TiposDiferentesTe
        this.context = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = Tiposte.get(position)
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.variedades_te, parent, false))
    }

    override fun getItemCount(): Int {
        return Tiposte.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val NombreTe = view.findViewById(R.id.Nombre_Te) as TextView
        val ImagenTe = view.findViewById(R.id.imagen_te) as ImageView

        fun bind(variedadete: VariedadesTe, context: Context) {
            NombreTe.text = variedadete.Tipo_te
            ImagenTe.loadUrl(variedadete.image)
            z(context)

            itemView.setOnClickListener(View.OnClickListener {
                Toast.makeText(context, "hola", Toast.LENGTH_SHORT).show()
            })
        }

        fun ImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(this)

        }

        fun RecyclerAdapter(DescripcionImagenes: MutableList<Imagen_Texto>, context: TeconCanela) {

        }

        fun z( context: Context) {
            ImagenTe.setOnClickListener {
                if (position == 0) {
                    val intent: Intent = Intent(context, TeVerde::class.java)
                    context.startActivity(intent)
                }else if (position == 1) {
                        val intent: Intent = Intent(context, TeNegro::class.java)
                        context.startActivity(intent)

                } else if (position == 2) {
                    val intent: Intent = Intent(context, TeVerdeconLimon::class.java)
                    context.startActivity(intent)
                } else if (position == 3) {
                    val intent: Intent = Intent(context, TedeJengibre::class.java)
                    context.startActivity(intent)
                } else if (position == 4) {
                    val intent: Intent = Intent(context, TeconMiel::class.java)
                    context.startActivity(intent)

                } else if (position == 5) {
                    val intent: Intent = Intent(context, TeconCanela::class.java)
                    context.startActivity(intent)
                } else if (position == 6) {
                    val intent: Intent = Intent(context, TeconManzanilla::class.java)
                    context.startActivity(intent)
                } else if (position == 7) {
                    val intent: Intent = Intent(context, TeconMenta::class.java)
                    context.startActivity(intent)




                }
            }
        }

    }
}


