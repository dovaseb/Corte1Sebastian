package com.example.example.corte1sebastian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel: MainViewModel = viewModel()
            val screen = intent.getStringExtra("screen") ?: "home" // Asegura que "home" sea la pantalla predeterminada

            AppNavigation(navController, viewModel, this)

            // Para navegar automáticamente a la pantalla correspondiente
            LaunchedEffect(Unit) {
                navController.navigate(screen)
            }
        }
    }
}