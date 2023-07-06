package com.example.puntosalexalberto.referenciados.ui

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.puntosalexalberto.referenciados.domain.ReferenciadosUseCase
import com.example.puntosalexalberto.referenciados.model.ReferenciadosState
import kotlinx.coroutines.launch

class ReferenciadosViewModel() : ViewModel() {
    private val TAG = "ReferenciadosViewModel"
    private val _referenciadosState =
        mutableStateOf<ReferenciadosState>(ReferenciadosState.Success(state = false))
    val referenciadosState = _referenciadosState

    //articulo
    private val _articuloState = mutableStateOf<String>("")
    val articuloState: State<String> = _articuloState
    fun articulo(articulo: String) {
        _articuloState.value = articulo
    }

    //nroDoc
    private val _nroDocState = mutableStateOf<String>("")
    val nroDocState: State<String> = _nroDocState
    fun nroDoc(nroDoc: String) {
        _nroDocState.value = nroDoc
    }

    //nombres
    private val _nombresState = mutableStateOf<String>("")
    val nombresState: State<String> = _nombresState
    fun nombres(nombres: String) {
        _nombresState.value = nombres
    }

    //apellidos
    private val _apellidosState = mutableStateOf<String>("")
    val apellidoState: State<String> = _apellidosState
    fun apellidos(apellidos: String) {
        _apellidosState.value = apellidos
    }

    //celular
    private val _celularState = mutableStateOf<String>("")
    val celularState: State<String> = _celularState
    fun celular(celular: String) {
        _celularState.value = celular
    }

    //contacto
    private val _contactoState = mutableStateOf<String>("")
    val contactoState: State<String> = _contactoState
    fun contacto(contacto: String){
        _contactoState.value = contacto
    }
    //horario
    private val _horarioState = mutableStateOf<String>("")
    val horarioState: State<String> = _horarioState
    fun horario(horario : String){
        _horarioState.value = horario
    }

    private val referenciadosUseCase = ReferenciadosUseCase()

    fun referenciar() {
        _referenciadosState.value = ReferenciadosState.Loading
        try {
            viewModelScope.launch {
                if (referenciadosUseCase(
                        _articuloState.value,
                        _nroDocState.value,
                        _nombresState.value,
                        _apellidosState.value,
                        _celularState.value,
                        _contactoState.value,
                        _horarioState.value
                    )
                ) {
                    _referenciadosState.value = ReferenciadosState.Success(true)
                } else {
                    _referenciadosState.value = ReferenciadosState.Success(true)
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "referenciar: e")
            _referenciadosState.value = ReferenciadosState.Error(e as Throwable)
        }
    }

}