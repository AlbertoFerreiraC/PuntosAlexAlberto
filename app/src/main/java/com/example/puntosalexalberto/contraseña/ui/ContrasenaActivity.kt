package com.example.puntosalexalberto.contraseña.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.puntosalexalberto.MainNavigation
import com.example.puntosalexalberto.contraseña.ui.ui.theme.PuntosAlexAlbertoTheme

class ContrasenaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuntosAlexAlbertoTheme {
                MainNavigation()
            }
        }
    }
}