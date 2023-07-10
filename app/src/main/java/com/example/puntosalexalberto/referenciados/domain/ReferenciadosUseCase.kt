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
        if (articulo.isEmpty()) {
            throw Exception("El articulo no debe ser nulo")
            return false
        } else if (nroDoc.isEmpty()) {
            throw Exception("El Nro de Documento no debe ser nulo")
            return false
        } else if (nombres.isEmpty()) {
            throw Exception("El nombre no debe ser nulo")
            return false
        } else if (apellidos.isEmpty()) {
            throw Exception("El Apellido no debe ser nulo")
            return false
        } else if (celular.isEmpty()) {
            throw Exception("El Nro de celular no debe ser nulo")
            return false
        }
        return true
    }
}