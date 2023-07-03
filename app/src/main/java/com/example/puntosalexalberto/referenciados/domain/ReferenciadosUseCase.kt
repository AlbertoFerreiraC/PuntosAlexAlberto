package com.example.puntosalexalberto.referenciados.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ReferenciadosUseCase {
    private val TAG = "ReferenciadosUseCase"

    suspend operator fun invoke(
        articulo: String,
        nroDoc: String,
        nombres: String,
        apellidos: String,
        celular: String
    ): Boolean {
        withContext(Dispatchers.IO) {
            delay(5000)
        }
        return true
    }
}