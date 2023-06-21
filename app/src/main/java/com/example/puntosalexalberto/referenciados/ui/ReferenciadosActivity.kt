package com.example.puntosalexalberto.referenciados.ui

import ReferenciadosScreem
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class ReferenciadosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReferenciadosScreem()
        }
    }
}