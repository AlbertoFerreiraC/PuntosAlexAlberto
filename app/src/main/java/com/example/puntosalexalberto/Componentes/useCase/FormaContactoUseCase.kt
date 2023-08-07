package com.example.puntosalexalberto.Componentes.useCase

class FormaContactoUseCase {
    private val TAG = "FormaContactoUseCase"
    operator fun invoke(): List<String> {
        return mutableListOf("Llamada", "WhatsApp", "SMS")
    }
}