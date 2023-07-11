package com.example.puntosalexalberto.contraseña.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.puntosalexalberto.contraseña.domain.ContrasenaUseCase
import com.example.puntosalexalberto.contraseña.model.ContrasenaState
import kotlinx.coroutines.launch

class ContrasenaViewModel : ViewModel() {
    private val TAG = "ContrasenaViewModel"
    private val _contrasenaState =
        mutableStateOf<ContrasenaState>(ContrasenaState.Success(state = false))
    val contrasenaState: State<ContrasenaState> = _contrasenaState

    private val _passState = mutableStateOf<String>("")
    val passState: State<String> = _passState
    fun pass(pass: String) {
        _passState.value = pass
    }

    private val _passVisiState = mutableStateOf<String>("")
    val passVisiState: State<String> = _passVisiState
    fun passVisi(passVisi: String) {
        _passVisiState.value = passVisi
    }

    private val contrasenaUseCase = ContrasenaUseCase()

    fun contrasena() {
        _contrasenaState.value = ContrasenaState.Loading

        viewModelScope.launch {
            try {
                if (contrasenaUseCase(_passState.value, _passVisiState.value)) {
                    _contrasenaState.value = ContrasenaState.Success(true)
                } else {
                    _contrasenaState.value = ContrasenaState.Success(false)
                }
            } catch (e: Exception) {
                _contrasenaState.value = ContrasenaState.Error(e as Throwable)
            }
        }
    }

}