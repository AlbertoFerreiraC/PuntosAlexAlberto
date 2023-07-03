package com.example.puntosalexalberto.promos.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.puntosalexalberto.promos.model.PromosState
import kotlinx.coroutines.launch
import java.lang.Exception

class PromosViewModel() : ViewModel() {
    private val TAG = "PromosViewModel"
    private val _promosState = mutableStateOf<PromosState>(PromosState.Success(state = true))
    val promosState = _promosState

    fun promos(){
        _promosState.value = PromosState.Loading
        try {
            viewModelScope.launch {

            }
        }catch (e: Exception){
            _promosState.value = PromosState.Error(e as Throwable)
        }
    }
}