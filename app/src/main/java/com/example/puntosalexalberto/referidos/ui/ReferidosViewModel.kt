package com.example.puntosalexalberto.referidos.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.puntosalexalberto.referidos.domain.ReferidosUseCase
import com.example.puntosalexalberto.referidos.model.ReferidosState
import kotlinx.coroutines.launch

class ReferidosViewModel(): ViewModel() {
    private val TAG = "ReferidosViewModel"
    private val _referidosState = mutableStateOf<ReferidosState>(ReferidosState.Success(state=true))
    val referidosState = _referidosState

    private val referidosUseCase = ReferidosUseCase()

    fun referidos(){
        _referidosState.value=ReferidosState.Loading
        try {
            viewModelScope.launch {

            }
        } catch (e: Exception){
            _referidosState.value= ReferidosState.Error(e as Throwable)
        }
    }
}