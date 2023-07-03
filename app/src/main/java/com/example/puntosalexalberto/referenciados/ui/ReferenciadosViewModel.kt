package com.example.puntosalexalberto.referenciados.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.puntosalexalberto.referenciados.domain.ReferenciadosUseCase
import com.example.puntosalexalberto.referenciados.model.ReferenciadosState
import kotlinx.coroutines.launch

class ReferenciadosViewModel() : ViewModel() {
    private val TAG = "ReferenciadosViewModel"
    private val _referenciadosState =
        mutableStateOf<ReferenciadosState>(ReferenciadosState.Success(state = true))
    val referenciadosState = _referenciadosState

    private val referenciadosUseCase = ReferenciadosUseCase()

    fun referenciar(
        articulo: String,
        nroDoc: String,
        nombres: String,
        apellidos: String,
        celular: String
    ) {
        _referenciadosState.value = ReferenciadosState.Loading
        try {
            viewModelScope.launch {
                if (referenciadosUseCase(articulo, nroDoc, nombres, apellidos, celular)) {
                    _referenciadosState.value = ReferenciadosState.Success(true)
                } else {
                    _referenciadosState.value = ReferenciadosState.Success(true)
                }
            }
        } catch (e: Exception) {
            _referenciadosState.value = ReferenciadosState.Error(e as Throwable)
        }
    }

}