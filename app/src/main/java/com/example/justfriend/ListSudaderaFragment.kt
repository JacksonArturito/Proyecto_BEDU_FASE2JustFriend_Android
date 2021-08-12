package com.example.justfriend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_list_sudadera.*

class ListSudaderaFragment : Fragment() {
    private lateinit var mAdapter1 : RecyclerAdapterSudadera
    private var listener1 : (Sudadera) ->Unit = {}

    override fun onCreateView(
        inflater1: LayoutInflater, container1: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater1.inflate(R.layout.fragment_list_sudadera, container1, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpRecyclerViewSudadera()
    }

    fun setListenerSudadera(ls: (Sudadera) ->Unit){
        listener1 = ls
    }

    //configuramos lo necesario para desplegar el RecyclerView
    private fun setUpRecyclerViewSudadera(){
        recyclerSudaderas.setHasFixedSize(true)
        recyclerSudaderas.layoutManager =  GridLayoutManager(
            activity,
            2,
            GridLayoutManager.VERTICAL,
            false
        )//LinearLayoutManager(activity)
        //seteando el Adapter
        mAdapter1 = RecyclerAdapterSudadera(requireActivity(), getSudaderas(), listener1)
        val largePaddings = resources.getDimensionPixelSize(R.dimen.product_grid_spacing)
        val smallPaddings = resources.getDimensionPixelSize(R.dimen.product_grid_spacing_small)
        recyclerSudaderas.addItemDecoration(GridDecoration(largePaddings, smallPaddings))
        //asignando el Adapter al RecyclerView
        recyclerSudaderas.adapter = mAdapter1
    }
    //generamos datos dummy con este método
    private fun getSudaderas(): MutableList<Sudadera>{
        var sudaderas:MutableList<Sudadera> = ArrayList()

        sudaderas.add(Sudadera("ABRÁZAME", "Ven corriendo a mi", "$456.00 MXN",4.3f,R.drawable.sudadera))
        sudaderas.add(Sudadera("ABRÁZAME", "Ven corriendo a mi", "$456.00 MXN",4.3f,R.drawable.sudadera))
        sudaderas.add(Sudadera("ABRÁZAME", "Ven corriendo a mi", "$456.00 MXN",4.3f,R.drawable.sudadera))
        sudaderas.add(Sudadera("ABRÁZAME", "Ven corriendo a mi", "$456.00 MXN",4.3f,R.drawable.sudadera))

        return sudaderas
    }
}