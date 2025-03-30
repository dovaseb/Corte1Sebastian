package com.example.example.corte1sebastian

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DocumentationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Documentación Técnica",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1976D2)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Aquí encontrarás ejemplos de documentación técnica: \n\n" +
                    "- Manual de usuario para un software de diseño\n" +
                    "- Informe técnico sobre la implementación de un nuevo sistema\n" +
                    "- Especificaciones técnicas para un componente electrónico\n" +
                    "- Guía de instalación para un equipo mecánico",
            fontSize = 16.sp,
            color = Color(0xFF424242)
        )
    }
}