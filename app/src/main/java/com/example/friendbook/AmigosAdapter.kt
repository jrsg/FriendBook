package com.example.friendbook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AmigosAdapter : RecyclerView.Adapter<AmigosVH> {

    private var data: ArrayList<Amigo>
    private var context: Context

    constructor(c : Context) : super(){
        data    = ArrayList()
        context = c
    }

    fun llenar(lista : ArrayList<Amigo>){
        data = lista
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmigosVH {
        val view : View = LayoutInflater.from( parent.context ).inflate(R.layout.amigo_fila, parent, false)

        return AmigosVH( view )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: AmigosVH, position: Int) {
        val amigo = data.get(position)

        holder.tvNombreAmigo.text = amigo.nombre
        holder.ivAvatarAmigo.setImageResource( amigo.avatar )
    }
}