package com.example.puntosalexalberto.referenciados.domain

import android.util.Log
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
        celular: String,
        contacto: String,
        horario: String

    ): Boolean {
        withContext(Dispatchers.IO) {
            Log.e(TAG, "Articulo: $articulo ", )
            delay(5000)
        }
        if (articulo.isEmpty()){
            throw Exception("El articulo no debe ser nulo")
            return false
        }
        return true
    }
}