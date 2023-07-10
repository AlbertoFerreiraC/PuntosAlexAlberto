package com.example.puntosalexalberto.datosUsu.model

sealed interface DatosUsuState {
    object Loading : DatosUsuState
    data class Error(val throwable: Throwable) : DatosUsuState
    data class Success(val state: Boolean) : DatosUsuState
}