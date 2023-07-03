package com.example.puntosalexalberto.DatosFun.model

sealed interface DatosFunState{
    object Loading : DatosFunState
    data class Error(val throwable: Throwable) : DatosFunState
    data class Succes(val state:Boolean): DatosFunState
}