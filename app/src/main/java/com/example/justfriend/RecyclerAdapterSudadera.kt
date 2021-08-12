package com.example.justfriend

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterSudadera (
    private val context1:Context,
    private val sudaderas: MutableList<Sudadera>,
    private val clickListener1: (Sudadera) -> Unit): RecyclerView.Adapter<RecyclerAdapterSudadera.ViewHolderSudadera>() {

    //Aquí atamos el ViewHolder
    override fun onBindViewHolder(holder: ViewHolderSudadera, position: Int) {
        val sudadera = sudaderas.get(position)
        holder.bind(sudadera, context1)

        holder.view.setOnClickListener{clickListener1(sudadera)}

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSudadera {
        val layoutInflater1 = LayoutInflater.from(parent.context)
        return ViewHolderSudadera(layoutInflater1.inflate(R.layout.item_sudadera, parent, false))
    }

    override fun getItemCount(): Int {
        return sudaderas.size
    }


    class ViewHolderSudadera(val view: View) : RecyclerView.ViewHolder(view) {
        //obteniendo las referencias a las Views
        val name = view.findViewById(R.id.nameSudadera) as TextView
        val description = view.findViewById(R.id.sudaderaDescription) as TextView
        val price = view.findViewById(R.id.sudaderaPrice) as TextView
        val image = view.findViewById(R.id.imgSudadera) as ImageView

        //"atando" los datos a las Views
        fun bind(sudadera: Sudadera, context: Context){
            name.text = sudadera.name
            description.text = sudadera.description
            price.text = sudadera.price
            image.setImageResource(sudadera.idImage)
        }
    }
}