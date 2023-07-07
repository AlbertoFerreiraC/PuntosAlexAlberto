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
        if (celular.isEmpty()){
            throw Exception("El numero de celular no debe ser nulo")
            return false
        } else if (cedula.isEmpty()){
            throw Exception("El numero de cedula no debe ser nulo")
            return false
        }
        return true
    }
}