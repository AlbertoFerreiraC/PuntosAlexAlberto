package com.example.puntosalexalberto.Componentes.useCase

class HorarioDisponibleUseCase {
    private val TAG = "HorarioDisponibleUseCase"
    operator fun invoke(): List<String> {
        return mutableListOf("INDISTINTO", "MAÑANA", "TARDE", "NOCHE")
    }
}