package com.example.puntosalexalberto.login.ui

import com.example.puntosalexalberto.referenciados.ui.ReferenciadosScreem
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginViewModel = LoginViewModel()

        setContent {
            LoginScreem(loginViewModel)//cambiar por LoginScreem()
        }
    }
}




