package com.example.puntosalexalberto.RegisUsu.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class RegisUseCase() {
    private val TAG = "RegisUseCase"

    suspend operator fun invoke(cedula: String):Boolean{
        withContext(Dispatchers.IO) {
            delay(5000)
        }
        if (cedula.isEmpty()) {
            throw Exception("El Nro de Documento no debe ser nulo")
            return false
        }
        return true
    }
}