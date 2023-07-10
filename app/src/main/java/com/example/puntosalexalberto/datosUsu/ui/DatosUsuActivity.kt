package com.example.puntosalexalberto.datosUsu.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.puntosalexalberto.MainNavigation
import com.example.puntosalexalberto.datosUsu.ui.ui.theme.PuntosAlexAlbertoTheme

class DatosUsuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuntosAlexAlbertoTheme {
                MainNavigation()
            }
        }
    }
}