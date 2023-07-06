package com.example.puntosalexalberto.login.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext


class LoginUseCase() {
    private val TAG = "LoginUseCase"

    suspend operator fun invoke(user: String, pass: String): Boolean {
        withContext(Dispatchers.IO) {
            delay(5000)//para test
        }
        if (user.isEmpty()) {
            throw Exception("Usuario no debe ser nulo")
            return false
        } else if (pass.isEmpty()) {
            throw Exception("Contraseña no debe ser nulo")
            return false
        }
        return true
    }
}