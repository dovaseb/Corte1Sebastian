package com.example.example.corte1sebastian

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicia ComposeActivity y navega a la pantalla "home"
        val intent = Intent(this, ComposeActivity::class.java)
        intent.putExtra("screen", "home") // Indica que debe mostrar la pantalla "home"
        startActivity(intent)
        finish() // Cierra MainActivity para que el usuario no vuelva a ella
    }
}