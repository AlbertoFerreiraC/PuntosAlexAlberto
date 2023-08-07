package com.example.puntosalexalberto.referenciados.model

data class ReferenciadosState(
    val Loading: Boolean = false,
    val Error: Throwable? = null,
    val Success: Boolean = true,
    val Referenciados: ReferenciadosUI = ReferenciadosUI()
)
