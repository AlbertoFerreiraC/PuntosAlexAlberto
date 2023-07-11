package com.example.puntosalexalberto.contraseña.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ContrasenaUseCase {
    private val TAG = "ContrasenaUseCase"

    suspend operator  fun invoke(pass: String, passVisi: String):Boolean{
        withContext(Dispatchers.IO){
            delay(2000)
        }
        if (pass.isEmpty()) {
            throw Exception("Debe completar el campo contraseña")
            return false
        } else if (passVisi.isEmpty()) {
            throw Exception("Las contraseñas no coinciden")
            return false
        }
        return true
    }
}