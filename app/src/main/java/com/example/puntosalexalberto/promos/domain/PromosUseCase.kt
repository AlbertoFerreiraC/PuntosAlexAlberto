package com.example.puntosalexalberto.promos.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class PromosUseCase() {
    private val TAG = "PromosUseCase"

    suspend operator fun invoke(): Boolean {
        withContext(Dispatchers.IO) {
            delay(5000)
        }
        return true
    }
}