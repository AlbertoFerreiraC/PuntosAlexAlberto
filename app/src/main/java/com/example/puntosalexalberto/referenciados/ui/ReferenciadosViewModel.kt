package com.example.puntosalexalberto.referenciados.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.puntosalexalberto.Componentes.useCase.FormaContactoUseCase
import com.example.puntosalexalberto.Componentes.useCase.HorarioDisponibleUseCase
import com.example.puntosalexalberto.referenciados.domain.ReferenciadosUseCase
import com.example.puntosalexalberto.referenciados.model.ReferenciadosState
import kotlinx.coroutines.launch

class ReferenciadosViewModel() : ViewModel() {
    private val TAG = "ReferenciadosViewModel"
    var referenciadosState by mutableStateOf(ReferenciadosState())
        private set

    fun articuloCarga(articulo: String) {
        referenciadosState =
            referenciadosState.copy(Referenciados = referenciadosState.Referenciados.copy(articulo = articulo))
    }

    fun nroDocCarga(nroDoc: String) {
        referenciadosState = referenciadosState.copy(
            Referenciados = referenciadosState.Referenciados.copy(nroDocumento = nroDoc)
        )
    }

    fun nombresCarga(nombres: String) {
        referenciadosState =
            referenciadosState.copy(Referenciados = referenciadosState.Referenciados.copy(nombres = nombres))
    }

    fun apellidosCarga(apellidos: String) {
        referenciadosState =
            referenciadosState.copy(Referenciados = referenciadosState.Referenciados.copy(apellidos = apellidos))
    }

    fun celularCarga(celular: String) {
        referenciadosState =
            referenciadosState.copy(Referenciados = referenciadosState.Referenciados.copy(nroCelular = celular))
    }

    private val _formaContactoUseCase = FormaContactoUseCase()
    val formaContactoList = _formaContactoUseCase()
    fun formaContactoCarga(contacto: String) {
        referenciadosState = referenciadosState.copy(
            Referenciados = referenciadosState.Referenciados.copy(formaContacto = contacto)
        )
    }

    private val _horarioDisponibleUseCase = HorarioDisponibleUseCase()
    val horarioDisponibleList = _horarioDisponibleUseCase()
    fun horarioDisponibleCarga(horario: String) {
        referenciadosState = referenciadosState.copy(
            Referenciados = referenciadosState.Referenciados.copy(horarioDisponible = horario)
        )
    }

    private val referenciadosUseCase = ReferenciadosUseCase()

    fun enviar() {
        referenciadosState = referenciadosState.copy(Loading = true)
        try {
            viewModelScope.launch {
                referenciadosUseCase(referenciados = referenciadosState.Referenciados)
            }
        } catch (e: Exception) {
            Log.e(TAG, "referenciar:  e")
            referenciadosState = referenciadosState.copy(Loading = false)
            referenciadosState = ReferenciadosState(Error = e)
        }
    }

}