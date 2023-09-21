package com.example.friendbook


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AmigosVH : RecyclerView.ViewHolder {
    var tvNombreAmigo : TextView
    var ivAvatarAmigo : ImageView

    constructor(itemView: View) : super(itemView){
        tvNombreAmigo = itemView.findViewById(R.id.tvNombreAmigo)
        ivAvatarAmigo = itemView.findViewById(R.id.ivAvatarAmigo)
    }
}
