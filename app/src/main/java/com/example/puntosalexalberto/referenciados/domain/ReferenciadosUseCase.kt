package com.example.puntosalexalberto.referenciados.domain

import android.util.Log
import com.example.puntosalexalberto.referenciados.model.ReferenciadosUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ReferenciadosUseCase {
    private val TAG = "ReferenciadosUseCase"

    suspend operator fun invoke(referenciados: ReferenciadosUI): Boolean {
        withContext(Dispatchers.IO) {
            Log.e(TAG, "Articulo: ${referenciados.articulo} ")
            delay(5000)
        }
        if (referenciados.articulo.isEmpty()) {
            throw Exception("El articulo no debe ser nulo")
        } else if (referenciados.nroDocumento.isEmpty()) {
            throw Exception("El Nro de Documento no debe ser nulo")
        } else if (referenciados.nombres.isEmpty()) {
            throw Exception("El nombre no debe ser nulo")
        } else if (referenciados.apellidos.isEmpty()) {
            throw Exception("El Apellido no debe ser nulo")
        } else if (referenciados.nroCelular.isEmpty()) {
            throw Exception("El Nro de celular no debe ser nulo")
        }

        Log.e(TAG, "invoke: $referenciados")

        return true
    }
}