package com.example.puntosalexalberto.promos.model

sealed interface PromosState {
    object Loading : PromosState
    data class Error(val throwable: Throwable) : PromosState
    data class Success(val state: Boolean) : PromosState
}