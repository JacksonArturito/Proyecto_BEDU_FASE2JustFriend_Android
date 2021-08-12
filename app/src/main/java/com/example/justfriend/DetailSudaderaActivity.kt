package com.example.justfriend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailSudaderaActivity : AppCompatActivity() {
    companion object {
        val SUDADERA = "SUDADERA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_sudadera)

        val sudadera = intent.getParcelableExtra<Sudadera>(SUDADERA)
        val detailFragmentS = supportFragmentManager.findFragmentById(R.id.fragmentDetailSudadera) as? DetailSudaderaFragment
        if (sudadera != null) {
            detailFragmentS?.showSudadera(sudadera)
        }

    }
}