package com.example.puntosalexalberto.referidos.model

sealed interface ReferidosState {
    object Loading : ReferidosState
    data class Error(val throwable: Throwable) : ReferidosState
    data class Success(val state: Boolean) : ReferidosState
}