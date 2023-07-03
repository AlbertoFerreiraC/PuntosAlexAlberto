package com.example.puntosalexalberto.DatosFun.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.puntosalexalberto.DatosFun.domain.DatosFunUseCase
import com.example.puntosalexalberto.DatosFun.model.DatosFunState
import kotlinx.coroutines.launch
import java.lang.Exception

class DatosFunViewModel() : ViewModel() {
    private val TAG = "DatosFunViewModel"
    private val _datosFunState = mutableStateOf<DatosFunState>(DatosFunState.Succes(state = true))
    val datosFunState = _datosFunState

    private val datosFunUseCase = DatosFunUseCase()

    fun Datos(celular: String, cedula: String) {
        _datosFunState.value = DatosFunState.Loading
        try {
            viewModelScope.launch {
                if (datosFunUseCase(celular, cedula)){
                    _datosFunState.value = DatosFunState.Succes(true)
                } else {
                    _datosFunState.value = DatosFunState.Succes(false)
                }
            }
        } catch (e: Exception){
            _datosFunState.value = DatosFunState.Error(e as Throwable)
        }
    }

}