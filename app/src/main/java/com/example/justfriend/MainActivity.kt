package com.example.justfriend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnPl: Button
    private lateinit var btnSud: Button
    private lateinit var btnSti: Button
    private lateinit var btnJug: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPl = findViewById(R.id.btnPlayera)
        btnSud = findViewById(R.id.btnSudadera)
        btnSti = findViewById(R.id.btnSticker)
        btnJug = findViewById(R.id.btnJuegos)

        btnPl.setOnClickListener{
            val bundle = Bundle()
            val intent = Intent(this, PlayerasActivity::class.java).apply { putExtras(bundle) }
            startActivity(intent)
        }

        btnSud.setOnClickListener{
            val bundle = Bundle()
            val intent = Intent(this, SudaderaActivity::class.java).apply { putExtras(bundle) }
            startActivity(intent)
        }

        btnSti.setOnClickListener{
            val bundle = Bundle()
            val intent = Intent(this, StickerActivity::class.java).apply { putExtras(bundle) }
            startActivity(intent)
        }

        btnJug.setOnClickListener{
            val bundle = Bundle()
            val intent = Intent(this, JuegoActivity::class.java).apply { putExtras(bundle) }
            startActivity(intent)
        }


    }
}