package com.example.puntosalexalberto.referenciados.ui

import com.example.puntosalexalberto.MainNavigation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class ReferenciadosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainNavigation()//por ahora se mantiene con una sola navegacion
        }
    }
}