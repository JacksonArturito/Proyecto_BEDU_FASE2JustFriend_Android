package com.example.justfriend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class DetailSudaderaFragment : Fragment() {
    private lateinit var nameSudadera: TextView
    private lateinit var sudaderaDescription: TextView
    private lateinit var sudaderaRate: RatingBar
    private lateinit var imgSudadera: ImageView
    private lateinit var sudaderaPrice: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view1 = inflater.inflate(R.layout.fragment_detail_sudadera, container, false)

        nameSudadera = view1.findViewById(R.id.nameSudadera)
        sudaderaDescription = view1.findViewById(R.id.sudaderaDescription)
        sudaderaRate = view1.findViewById(R.id.sudaderaRate)
        imgSudadera = view1.findViewById(R.id.imgSudadera)
        sudaderaPrice = view1.findViewById(R.id.sudaderaPrice)

        return view1
    }

    fun showSudadera(sudadera: Sudadera){
        view?.visibility = View.VISIBLE
        nameSudadera.text = sudadera.name
        sudaderaDescription.text = sudadera.description
        sudaderaRate.rating = sudadera.rating
        imgSudadera.setImageResource(sudadera.idImage)
        sudaderaPrice .text = sudadera.price

    }
}