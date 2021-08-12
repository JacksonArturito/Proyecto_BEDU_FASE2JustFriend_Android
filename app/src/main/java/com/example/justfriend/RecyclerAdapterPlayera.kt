package com.example.justfriend

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterPlayera (
    private val context:Context,
    private val playeras: MutableList<Playera>,
    private val clickListener: (Playera) -> Unit): RecyclerView.Adapter<RecyclerAdapterPlayera.ViewHolder>() {

    //Aquí atamos el ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val playera = playeras.get(position)
        holder.bind(playera, context)

        holder.view.setOnClickListener{clickListener(playera)}

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_playera, parent, false))
    }

    override fun getItemCount(): Int {
        return playeras.size
    }


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        //obteniendo las referencias a las Views
        val name = view.findViewById(R.id.namePlayera) as TextView
        val description = view.findViewById(R.id.playeraDescription) as TextView
        val price = view.findViewById(R.id.playeraPrice) as TextView
        val image = view.findViewById(R.id.imgPlayera) as ImageView

        //"atando" los datos a las Views
        fun bind(playera: Playera, context: Context){
            name.text = playera.name
            description.text = playera.description
            price.text = playera.price
            image.setImageResource(playera.idImage)
        }
    }
}