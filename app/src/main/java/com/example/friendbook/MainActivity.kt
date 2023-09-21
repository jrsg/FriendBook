package com.example.friendbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var adapter : AmigosAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvAmigos : RecyclerView = findViewById(R.id.rvAmigos)

        val lista               = llenarListaAmigos()
        adapter                 = AmigosAdapter(this)

        adapter.llenar(lista)

        rvAmigos.addItemDecoration(DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL))
        rvAmigos.adapter        = adapter
        rvAmigos.layoutManager  = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun llenarListaAmigos() : ArrayList<Amigo>{
        val amigos = resources.getStringArray(R.array.amigos)

        val lista : ArrayList<Amigo> = ArrayList()

        for(i in amigos.indices){

            val amigo = Amigo()

            val datos = amigos[i].split(":")

            amigo.nombre        = datos[0]
            amigo.telefono      = datos[1]
            amigo.email         = datos[2]
            amigo.direccion     = datos[3]
            amigo.avatar        = calcularIdImagen(i + 1)

            lista.add( amigo )
        }

        return lista
    }

    private fun calcularIdImagen(i: Int): Int {
        return resources.getIdentifier(
            "persona$i",
            "drawable",
            packageName)
    }
}