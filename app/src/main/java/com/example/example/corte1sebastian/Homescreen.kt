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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController, viewModel: MainViewModel) {
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
            .safeDrawingPadding() // Agregamos padding seguro
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título de la aplicación
        Text(
            "TechEnglish",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = if (backgroundColor == Color.Black) Color.White else accentColor,
            modifier = Modifier.padding(top = 24.dp, bottom = 16.dp)
        )

        Text(
            "Inglés especializado para ingenieros",
            fontSize = 18.sp,
            color = subtitleColor,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Tarjeta de Vocabulario Técnico
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = cardColor
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    "Vocabulario Técnico",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (backgroundColor == Color.Black) Color.White else accentColor
                )
                Text(
                    "Aprende términos especializados de ingeniería, informática, mecánica y electrónica.",
                    fontSize = 16.sp,
                    color = subtitleColor,
                    modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
                )
                Button(
                    onClick = { navController.navigate("vocabulary") }, // Navega a VocabularyScreen
                    modifier = Modifier.align(Alignment.End),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (backgroundColor == Color.Black) Color(0xFF2196F3) else accentColor
                    )
                ) {
                    Text("Ir a Vocabulario")
                }
            }
        }

        // Tarjeta de Documentación Técnica
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = cardColor
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    "Documentación Técnica",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (backgroundColor == Color.Black) Color.White else accentColor
                )
                Text(
                    "Practica la lectura y escritura de manuales, informes y especificaciones técnicas.",
                    fontSize = 16.sp,
                    color = subtitleColor,
                    modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
                )
                Button(
                    onClick = { navController.navigate("documentation") }, // Navega a DocumentationScreen
                    modifier = Modifier.align(Alignment.End),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (backgroundColor == Color.Black) Color(0xFF2196F3) else accentColor
                    )
                ) {
                    Text("Ir a Documentación")
                }
            }
        }

        // Botones de Detalles y Configuración movidos aquí
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { navController.navigate("details") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (backgroundColor == Color.Black) Color(0xFF2196F3) else accentColor
                )
            ) {
                Text("Ir a Detalles")
            }

            Button(
                onClick = { navController.navigate("settings") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (backgroundColor == Color.Black) Color(0xFF2196F3) else accentColor
                )
            ) {
                Text("Ir a Configuración")
            }
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}