package com.example.puntosalexalberto.DatosFun.ui

import androidx.compose.runtime.State
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

    private val _celularState = mutableStateOf<String>("")
    val celularState : State<String> = _celularState
    fun celular(celular: String){
        _celularState.value = celular
    }
    private val _cedulaState = mutableStateOf<String>("")
    val cedulaState : State<String> = _cedulaState
    fun cedula(cedula: String){
        _cedulaState.value = cedula
    }

    private val datosFunUseCase = DatosFunUseCase()

    fun Datos() {
        _datosFunState.value = DatosFunState.Loading
        try {
            viewModelScope.launch {
                if (datosFunUseCase(_celularState.value, _cedulaState.value)){
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