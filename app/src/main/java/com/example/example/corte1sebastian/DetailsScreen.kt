package com.example.example.corte1sebastian

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen(viewModel: MainViewModel) {
    // Observamos el color de fondo actual
    val backgroundColor by viewModel.backgroundColor.observeAsState(Color.White)
    val colorName by viewModel.colorName.observeAsState("white")

    // Definimos colores basados en el tema actual
    val textColor = if (backgroundColor == Color.Black) Color.White else Color(0xFF333333)
    val cardColor = if (backgroundColor == Color.Black) Color(0xFF333333) else Color.White
    val accentColor = when (backgroundColor) {
        Color.Blue -> Color(0xFF1E88E5)
        Color.Black -> Color(0xFF2196F3)
        else -> Color(0xFF1976D2) // Para fondo blanco
    }
    val subtitleColor = if (backgroundColor == Color.Black) Color.White.copy(alpha = 0.7f) else Color(0xFF757575)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título de la sección
        Text(
            "Acerca de TechEnglish",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = textColor,
            modifier = Modifier.padding(top = 24.dp, bottom = 16.dp),
            textAlign = TextAlign.Center
        )

        // Imagen o logo
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(60.dp))
                .background(accentColor)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "TE",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Información de la aplicación
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = cardColor
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Versión 1.0.0",
                    fontSize = 18.sp,
                    color = subtitleColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Divider(
                    modifier = Modifier.padding(vertical = 8.dp),
                    color = if (backgroundColor == Color.Black)
                        Color.White.copy(alpha = 0.2f) else Color(0xFFE0E0E0)
                )

                Text(
                    "TechEnglish es una aplicación diseñada para ayudar a ingenieros y profesionales técnicos a mejorar sus habilidades en inglés especializado.",
                    fontSize = 16.sp,
                    color = textColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Divider(
                    modifier = Modifier.padding(vertical = 8.dp),
                    color = if (backgroundColor == Color.Black)
                        Color.White.copy(alpha = 0.2f) else Color(0xFFE0E0E0)
                )

                Text(
                    "Características principales:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                )

                Text(
                    "• Vocabulario técnico especializado\n• Ejemplos prácticos para ingenieros\n• Frases comunes en entornos profesionales\n• Personalización de temas visuales",
                    fontSize = 16.sp,
                    color = textColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Información sobre tema actual
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(
                    if (backgroundColor == Color.Black)
                        Color(0xFF1E1E1E) else Color(0xFFE3F2FD)
                )
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Tema actual: ${colorName.capitalize()}",
                fontSize = 14.sp,
                color = if (backgroundColor == Color.Black)
                    Color.White else accentColor
            )
        }
    }
}