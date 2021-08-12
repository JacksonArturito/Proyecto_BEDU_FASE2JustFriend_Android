package com.example.justfriend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SudaderaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playeras)

        val listFragment1 = supportFragmentManager.findFragmentById(R.id.fragmentListSudadera) as ListSudaderaFragment
        print(listFragment1)
        listFragment1.setListenerSudadera{
            val detailFragment1 = supportFragmentManager.findFragmentById(R.id.fragmentDetailSudadera) as? DetailSudaderaFragment

            // Pantalla grande, mostrar detalle en el fragment
            if(detailFragment1!=null){
                detailFragment1.showSudadera(it)
            } else{ //pantalla pequeña, navegar a un nuevo Activity
                val intent = Intent(this, DetailSudaderaActivity::class.java)
                intent.putExtra(DetailSudaderaActivity.SUDADERA,it)
                startActivity(intent)
            }
        }
    }
}