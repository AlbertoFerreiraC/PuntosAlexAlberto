package com.example.puntosalexalberto.promos.ui

import MainNavigation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.puntosalexalberto.referidos.ui.ReferidosScreem

class PromosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainNavigation()//por ahora se mantiene con una sola navegacion
        }
    }
}

