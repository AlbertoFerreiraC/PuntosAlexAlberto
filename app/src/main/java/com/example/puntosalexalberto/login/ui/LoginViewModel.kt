package com.example.puntosalexalberto.login.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.puntosalexalberto.login.domain.LoginUseCase
import com.example.puntosalexalberto.login.model.LoginState
import kotlinx.coroutines.launch

class LoginViewModel() : ViewModel() {

    private val TAG = "LoginViewModel"
    private val _loginState = mutableStateOf<LoginState>(LoginState.Success(state = true))
    val loginState = _loginState

    private val loginUseCase = LoginUseCase()

    fun login(user: String, pass: String) {

        _loginState.value = LoginState.Loading

        try {
            viewModelScope.launch {
                if (loginUseCase(user, pass)) {
                    _loginState.value = LoginState.Success(true)
                } else {
                    _loginState.value = LoginState.Success(false)
                }
            }
        } catch (e: Exception) {
            _loginState.value = LoginState.Error(e as Throwable)
        }
    }

}