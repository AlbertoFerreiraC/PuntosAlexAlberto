package com.example.puntosalexalberto.RegisUsu.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.puntosalexalberto.RegisUsu.domain.RegisUseCase
import com.example.puntosalexalberto.RegisUsu.model.RegisUsuState
import kotlinx.coroutines.launch

class RegisUsuViewModel() : ViewModel() {
    private val TAG = "RegisUsuViewModel"
    private val _regisUsuState = mutableStateOf<RegisUsuState>(RegisUsuState.Success(state = true))
    val regisUsuState = _regisUsuState

    private val regisUseCase = RegisUseCase()

    fun regisUsuario(cedula: String) {
        _regisUsuState.value = RegisUsuState.Loading
        try {
            viewModelScope.launch {
                if (regisUseCase(cedula)) {
                    _regisUsuState.value = RegisUsuState.Success(true)
                }
            }
        } catch (e: Exception) {
            _regisUsuState.value = RegisUsuState.Error(e as Throwable)
        }
    }
}