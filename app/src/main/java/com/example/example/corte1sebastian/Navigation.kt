package com.example.example.corte1sebastian

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(navController: NavHostController, viewModel: MainViewModel, context: Context) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController, viewModel) }
        composable("details") { DetailScreen(viewModel) }
        composable("settings") { SettingsScreen(viewModel, context) }
        composable("vocabulary") { VocabularyScreen() } // Nueva ruta
        composable("documentation") { DocumentationScreen() } // Nueva ruta
    }
}