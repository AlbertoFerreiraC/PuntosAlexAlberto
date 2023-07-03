package com.example.puntosalexalberto.referenciados.model

sealed interface ReferenciadosState {
    object Loading : ReferenciadosState
    data class Error(val throwable: Throwable) : ReferenciadosState
    data class Success(val state: Boolean) : ReferenciadosState
}