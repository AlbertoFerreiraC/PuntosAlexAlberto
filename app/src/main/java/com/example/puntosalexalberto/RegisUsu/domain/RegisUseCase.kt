package com.example.puntosalexalberto.RegisUsu.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class RegisUseCase() {
    private val TAG = "RegisUseCase"

    suspend operator fun invoke(cedula: String):Boolean{
        withContext(Dispatchers.IO){
            delay(5000)
        }
        return true
    }
}