package com.example.justfriend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class DetailPlayeraFragment : Fragment() {
    private lateinit var namePlayera: TextView
    private lateinit var playeraDescription: TextView
    private lateinit var playeraRate: RatingBar
    private lateinit var imgPlayera: ImageView
    private lateinit var playeraPrice: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_playera, container, false)

        namePlayera = view.findViewById(R.id.namePlayera)
        playeraDescription = view.findViewById(R.id.playeraDescription)
        playeraRate = view.findViewById(R.id.playeraRate)
        imgPlayera = view.findViewById(R.id.imgPlayera)
        playeraPrice = view.findViewById(R.id.playeraPrice)

        return view
    }

    fun showPlayera(playera: Playera){
        view?.visibility = View.VISIBLE
        namePlayera.text = playera.name
        playeraDescription.text = playera.description
        playeraRate.rating = playera.rating
        imgPlayera.setImageResource(playera.idImage)
        playeraPrice.text = playera.price

    }


}