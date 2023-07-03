package com.example.puntosalexalberto.referidos.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ReferidosUseCase() {
    private val TAG = "ReferidosUseCase"

    suspend operator fun invoke():Boolean{
        withContext(Dispatchers.IO){
            delay(5000)
        }
        return true
    }
}