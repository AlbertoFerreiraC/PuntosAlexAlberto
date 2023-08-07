package com.example.puntosalexalberto.login.domain

import com.example.puntosalexalberto.login.data.source.LoginRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext


class LoginUseCase() {
    private val TAG = "LoginUseCase"

    suspend operator fun invoke(user: String, pass: String): Boolean {
        val loginRepo: ILoginRepo = LoginRepo()
        withContext(Dispatchers.IO) {
            delay(2000)
            loginRepo.login(user, pass)
            if (user.isEmpty()) {
                throw Exception("Usuario no debe ser nulo")
            } else if (pass.isEmpty()) {
                throw Exception("Contraseña no debe ser nulo")
            }
        }
        return true
    }
}