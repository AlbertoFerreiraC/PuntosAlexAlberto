package com.example.puntosalexalberto.login.ui

import ReferenciadosScreem
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReferenciadosScreem()//cambiar por LoginScreem()
        }
    }
}




