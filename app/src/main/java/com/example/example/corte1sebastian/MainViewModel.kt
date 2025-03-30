package com.example.example.corte1sebastian

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // Usamos un MutableLiveData para almacenar el color actual
    private val _backgroundColor = MutableLiveData<Color>(Color.White)
    val backgroundColor: LiveData<Color> = _backgroundColor

    // Guardamos también el nombre del color para facilitar el manejo
    private val _colorName = MutableLiveData<String>("white")
    val colorName: LiveData<String> = _colorName

    fun setBackgroundColor(color: Color, colorName: String) {
        _backgroundColor.value = color
        _colorName.value = colorName
    }
}