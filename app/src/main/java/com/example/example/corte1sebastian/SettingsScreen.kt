package com.example.example.corte1sebastian

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
fun SettingsScreen(viewModel: MainViewModel, context: Context) {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)

    // Observe el color actual
    val currentColor by viewModel.backgroundColor.observeAsState(Color.White)
    val currentColorName by viewModel.colorName.observeAsState("white")

    // Definimos colores basados en el tema actual
    val textColor = if (currentColor == Color.Black) Color.White else Color(0xFF333333)
    val cardColor = if (currentColor == Color.Black) Color(0xFF333333) else Color.White
    val accentColor = when (currentColor) {
        Color.Blue -> Color(0xFF1E88E5)
        Color.Black -> Color(0xFF2196F3)
        else -> Color(0xFF1976D2) // Para fondo blanco
    }
    val subtitleColor = if (currentColor == Color.Black) Color.White.copy(alpha = 0.7f) else Color(0xFF757575)

    // Cargar preferencias guardadas al iniciar
    LaunchedEffect(Unit) {
        val savedColorName = sharedPreferences.getString("colorName", "white") ?: "white"
        val color = when (savedColorName) {
            "blue" -> Color.Blue
            "black" -> Color.Black
            else -> Color.White
        }
        viewModel.setBackgroundColor(color, savedColorName)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(currentColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título de la sección
        Text(
            "Configuración",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = textColor,
            modifier = Modifier.padding(top = 24.dp, bottom = 16.dp),
            textAlign = TextAlign.Center
        )

        Text(
            "Personaliza la apariencia de la aplicación",
            fontSize = 16.sp,
            color = subtitleColor,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Sección de temas
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            colors = CardDefaults.cardColors(
                containerColor = cardColor
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Tema de la aplicación",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (currentColor == Color.Black) Color.White else accentColor,
                    modifier = Modifier.padding(bottom = 16.dp),
                    textAlign = TextAlign.Center
                )

                // Muestra del tema actual
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(
                            if (currentColor == Color.Black)
                                Color(0xFF424242) else Color(0xFFE3F2FD)
                        )
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        // Círculo de color del tema actual
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(CircleShape)
                                .background(currentColor)
                                .border(
                                    width = 1.dp,
                                    color = if (currentColor == Color.White) Color.LightGray else Color.Transparent,
                                    shape = CircleShape
                                )
                                .padding(4.dp)
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            "Tema actual: ${currentColorName.capitalize()}",
                            fontSize = 16.sp,
                            color = if (currentColor == Color.Black)
                                Color.White else Color(0xFF424242)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Botones de tema
                Text(
                    "Selecciona un tema:",
                    fontSize = 16.sp,
                    color = subtitleColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    // Botón para tema azul
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            onClick = {
                                viewModel.setBackgroundColor(Color.Blue, "blue")
                                sharedPreferences.edit().putString("colorName", "blue").apply()
                            },
                            modifier = Modifier.size(64.dp),
                            contentPadding = PaddingValues(0.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Blue
                            ),
                            shape = CircleShape
                        ) {
                            if (currentColorName == "blue") {
                                Box(
                                    modifier = Modifier
                                        .size(32.dp)
                                        .clip(CircleShape)
                                        .background(Color.White.copy(alpha = 0.3f))
                                )
                            }
                        }

                        Text(
                            "Azul",
                            fontSize = 16.sp,
                            color = subtitleColor,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }

                    // Botón para tema negro
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            onClick = {
                                viewModel.setBackgroundColor(Color.Black, "black")
                                sharedPreferences.edit().putString("colorName", "black").apply()
                            },
                            modifier = Modifier.size(64.dp),
                            contentPadding = PaddingValues(0.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black
                            ),
                            shape = CircleShape
                        ) {
                            if (currentColorName == "black") {
                                Box(
                                    modifier = Modifier
                                        .size(32.dp)
                                        .clip(CircleShape)
                                        .background(Color.White.copy(alpha = 0.3f))
                                )
                            }
                        }

                        Text(
                            "Negro",
                            fontSize = 16.sp,
                            color = subtitleColor,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }

                    // Botón para tema blanco
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            onClick = {
                                viewModel.setBackgroundColor(Color.White, "white")
                                sharedPreferences.edit().putString("colorName", "white").apply()
                            },
                            modifier = Modifier
                                .size(64.dp)
                                .border(
                                    width = 1.dp,
                                    color = Color.LightGray,
                                    shape = CircleShape
                                ),
                            contentPadding = PaddingValues(0.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White
                            ),
                            shape = CircleShape
                        ) {
                            if (currentColorName == "white") {
                                Box(
                                    modifier = Modifier
                                        .size(32.dp)
                                        .clip(CircleShape)
                                        .background(Color.Black.copy(alpha = 0.1f))
                                )
                            }
                        }

                        Text(
                            "Blanco",
                            fontSize = 16.sp,
                            color = subtitleColor,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Vista previa de la aplicación del tema
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
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Vista previa",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (currentColor == Color.Black) Color.White else accentColor,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(currentColor)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "TechEnglish",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (currentColor == Color.Black) Color.White else accentColor
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            "Inglés para ingenieros",
                            fontSize = 16.sp,
                            color = if (currentColor == Color.Black) Color.White.copy(alpha = 0.7f) else Color(0xFF757575)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = { /* No acción */ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (currentColor == Color.Black) Color(0xFF2196F3) else accentColor
                            ),
                            modifier = Modifier.width(150.dp)
                        ) {
                            Text("Ejemplo de botón")
                        }
                    }
                }
            }
        }
    }
}