package com.example.puntosalexalberto.datosUsu.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.puntosalexalberto.datosUsu.domain.DatosUseCase
import com.example.puntosalexalberto.datosUsu.model.DatosUsuState
import kotlinx.coroutines.launch

class DatosUsuViewModel : ViewModel() {

    private val TAG = "DatosUsuViewModel"
    private val _datosUsuState = mutableStateOf<DatosUsuState>(DatosUsuState.Success(state = false))
    val datosUsuState: State<DatosUsuState> = _datosUsuState

    private val _nombreState = mutableStateOf<String>("")
    val nombreState: State<String> = _nombreState
    fun nombre(nombre: String) {
        _nombreState.value = nombre
    }

    private val _apellidoState = mutableStateOf<String>("")
    val apellidoState: State<String> = _apellidoState
    fun apellido(apellido: String) {
        _apellidoState.value = apellido
    }

    private val _celularState = mutableStateOf<String>("")
    val celularState: State<String> = _celularState
    fun celular(celular: String) {
        _celularState.value = celular
    }

    private val _ciuFuncionarioState = mutableStateOf<String>("")
    val ciFuncionarioState: State<String> = _ciuFuncionarioState
    fun cifun(cifun: String) {
        _ciuFuncionarioState.value = cifun
    }

    private val datosUseCase = DatosUseCase()

    fun datos() {
        _datosUsuState.value = DatosUsuState.Loading

        viewModelScope.launch {
            try {
                if (datosUseCase(
                        _nombreState.value,
                        _apellidoState.value,
                        _celularState.value,
                        _ciuFuncionarioState.value
                    )
                ) {
                    _datosUsuState.value = DatosUsuState.Success(true)
                } else {
                    _datosUsuState.value = DatosUsuState.Success(false)
                }
            } catch (e: Exception) {
                _datosUsuState.value = DatosUsuState.Error(e as Throwable)
            }
        }
    }

}