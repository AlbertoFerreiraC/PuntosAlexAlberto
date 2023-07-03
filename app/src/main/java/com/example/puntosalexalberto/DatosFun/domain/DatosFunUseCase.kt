package com.example.puntosalexalberto.DatosFun.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class DatosFunUseCase() {
    private val TAG = "DatosFunUseCase"

    suspend operator fun invoke(celular: String, cedula:String):Boolean{
     withContext(Dispatchers.IO){
         delay(5000)
     }
        return true
    }
}