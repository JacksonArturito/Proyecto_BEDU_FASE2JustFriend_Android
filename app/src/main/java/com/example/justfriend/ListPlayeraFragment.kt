package com.example.justfriend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_list_playera.*

class ListPlayeraFragment : Fragment() {
    private lateinit var mAdapter : RecyclerAdapterPlayera
    private var listener : (Playera) ->Unit = {}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_playera, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpRecyclerView()
    }

    fun setListener(l: (Playera) ->Unit){
        listener = l
    }

    //configuramos lo necesario para desplegar el RecyclerView
    private fun setUpRecyclerView(){
        recyclerPlayeras.setHasFixedSize(true)
        recyclerPlayeras.layoutManager =  GridLayoutManager(
            activity,
            2,
            GridLayoutManager.VERTICAL,
            false
        )//LinearLayoutManager(activity)
        //seteando el Adapter
        mAdapter = RecyclerAdapterPlayera(requireActivity(), getPlayeras(), listener)
        val largePadding = resources.getDimensionPixelSize(R.dimen.product_grid_spacing)
        val smallPadding = resources.getDimensionPixelSize(R.dimen.product_grid_spacing_small)
        recyclerPlayeras.addItemDecoration(GridDecoration(largePadding, smallPadding))
        //asignando el Adapter al RecyclerView
        recyclerPlayeras.adapter = mAdapter
    }
    //generamos datos dummy con este método
    private fun getPlayeras(): MutableList<Playera>{
        var playeras:MutableList<Playera> = ArrayList()

        playeras.add(Playera("CHILL", "Vamos a ver Netflix a mi depa?", "$256.00 MXN",4.6f,R.drawable.playera1))
        playeras.add(Playera("ON FIRE", "Faya", "$256.00 MXN",4.4f,R.drawable.playera2))
        playeras.add(Playera("EL AMOR DE TU VIDA", "Hola", "$256.00 MXN",3.8f,R.drawable.playera3))
        playeras.add(Playera("TU FUTURO EX", "Yup", "$256.00 MXN",4.8f,R.drawable.playera4))
        playeras.add(Playera("CUENTA DINERO NO CALORIAS (MAROON)", "Cuenta dinero no calorias paps", "$256.00 MXN",4.8f,R.drawable.playera5))
        playeras.add(Playera("WIFI", "Algún día lo sabrás!", "$256.00 MXN",4.8f,R.drawable.playera6))

        return playeras
    }
}