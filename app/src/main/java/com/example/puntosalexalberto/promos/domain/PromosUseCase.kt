package com.example.puntosalexalberto.promos.domain

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.puntosalexalberto.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class PromosUseCase() {
    private val TAG = "PromosUseCase"

    suspend operator fun invoke(): Boolean {
        withContext(Dispatchers.IO) {
            delay(5000)
        }
        return true
    }
    //Consultar si se puede hacer esto
    @Composable
    fun img(palabra: Int = R.drawable.puntosalex): Painter {
        return painterResource(id = palabra)
    }

    @Composable
    fun imagen(palabra: Int = R.drawable.catalogo): Painter {
        return painterResource(id = palabra)
    }

    @Composable
    fun texto(texto: Int = R.string.app_name): Int {
        return texto
    }
}