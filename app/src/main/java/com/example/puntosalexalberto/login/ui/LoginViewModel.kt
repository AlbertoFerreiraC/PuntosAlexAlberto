package com.example.puntosalexalberto.login.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.puntosalexalberto.MainNavigation
import com.example.puntosalexalberto.login.domain.LoginUseCase
import com.example.puntosalexalberto.login.model.LoginState
import kotlinx.coroutines.launch

class LoginViewModel() : ViewModel() {

    private val TAG = "LoginViewModel"
    private val _loginState = mutableStateOf<LoginState>(LoginState.Success(state = false))
    val loginState: State<LoginState> = _loginState

    private val _cedulaState = mutableStateOf<String>("")
    val cedulaState: State<String> = _cedulaState

    fun cedula(cedula: String){
        _cedulaState.value = cedula
    }

    private val _passState = mutableStateOf<String>("")
    val passState : State<String> = _passState

    fun pass(pass: String){
        _passState.value = pass
    }

    private val loginUseCase = LoginUseCase()

    fun login() {
        _loginState.value = LoginState.Loading

        viewModelScope.launch {
            try {
                if (loginUseCase(_cedulaState.value, _passState.value)) {
                    _loginState.value = LoginState.Success(true)
                } else {
                    _loginState.value = LoginState.Success(false)
                }
            } catch (e: Exception) {
                _loginState.value = LoginState.Error(e as Throwable)
            }
        }
    }

}
