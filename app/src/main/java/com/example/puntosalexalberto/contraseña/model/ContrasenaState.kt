package com.example.puntosalexalberto.contraseña.model

sealed interface ContrasenaState {
    object Loading : ContrasenaState
    data class Error(val throwable: Throwable) : ContrasenaState
    data class Success(val state: Boolean) : ContrasenaState
}