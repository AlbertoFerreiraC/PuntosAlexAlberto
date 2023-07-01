package com.example.puntosalexalberto.login.model

sealed interface LoginState {
    object Loading : LoginState
    data class Error(val throwable: Throwable) : LoginState
    data class Success(val state:Boolean) : LoginState
}