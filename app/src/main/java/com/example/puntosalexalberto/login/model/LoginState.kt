package com.example.puntosalexalberto.login.model

/**
 *@author Julio Cabrera
 *Created 24/6/2023 at 07:36
 **/
sealed interface LoginState {
    object Loading : LoginState
    data class Error(val throwable: Throwable) : LoginState
    data class Success(val state:Boolean) : LoginState
}