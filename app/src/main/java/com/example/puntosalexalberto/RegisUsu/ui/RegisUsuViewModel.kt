package com.example.puntosalexalberto.RegisUsu.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.puntosalexalberto.RegisUsu.domain.RegisUseCase
import com.example.puntosalexalberto.RegisUsu.model.RegisUsuState
import kotlinx.coroutines.launch

class RegisUsuViewModel() : ViewModel() {
    private val TAG = "RegisUsuViewModel"
    private val _regisUsuState = mutableStateOf<RegisUsuState>(RegisUsuState.Success(state = false))
    val regisUsuState = _regisUsuState

    private val regisUseCase = RegisUseCase()

    private val _cedulaState = mutableStateOf<String>("")
    val cedulaState: State<String> = _cedulaState
    fun cedula(cedula: String) {
        _cedulaState.value = cedula
    }

    fun regisUsuario() {
        _regisUsuState.value = RegisUsuState.Loading
        viewModelScope.launch {
            try {
                if (regisUseCase(_cedulaState.value)) {
                    _regisUsuState.value = RegisUsuState.Success(true)
                }

            } catch (e: Exception) {
                _regisUsuState.value = RegisUsuState.Error(e as Throwable)
            }
        }
    }
}