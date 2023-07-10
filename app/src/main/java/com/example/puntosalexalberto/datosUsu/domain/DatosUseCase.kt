package com.example.puntosalexalberto.datosUsu.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class DatosUseCase {
    private val TAG = "DatosUseCase"

    suspend operator fun invoke(
        nombre: String,
        apellido: String,
        celular: String,
        cifun: String
    ): Boolean {
        withContext(Dispatchers.IO) {
            delay(2000)
        }
        if (nombre.isEmpty()) {
            throw Exception("El nombre no debe ser nulo")
            return false
        } else if (apellido.isEmpty()) {
            throw Exception("El apellido no debe ser nulo")
            return false
        } else if (celular.isEmpty()) {
            throw Exception("El numero de celular no debe ser nulo")
            return false
        } else if (cifun.isEmpty()) {
            throw Exception("El numero de documento del funcionario no debe ser nulo")
            return false
        }
        return true
    }

}