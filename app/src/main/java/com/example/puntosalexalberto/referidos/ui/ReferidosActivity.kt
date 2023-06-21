package com.example.puntosalexalberto.referidos.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.puntosalexalberto.referidos.ui.ReferidosScreem

class ReferidosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReferidosScreem()
        }
    }
}