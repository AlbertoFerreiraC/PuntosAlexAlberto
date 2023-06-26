package com.example.puntosalexalberto.referidos.ui

import com.example.puntosalexalberto.MainNavigation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class ReferidosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainNavigation()//por ahora se mantiene con una sola navegacion
        }
    }
}