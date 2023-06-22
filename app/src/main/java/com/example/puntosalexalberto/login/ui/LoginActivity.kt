package com.example.puntosalexalberto.login.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.puntosalexalberto.referenciados.ui.ReferenciadosScreem

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReferenciadosScreem()//cambiar por LoginScreem()
        }
    }
}




