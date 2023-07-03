package com.example.puntosalexalberto.RegisUsu.model

sealed interface RegisUsuState {
    object Loading : RegisUsuState
    data class Error(val throwable: Throwable) : RegisUsuState
    data class Success(val state: Boolean) : RegisUsuState
}