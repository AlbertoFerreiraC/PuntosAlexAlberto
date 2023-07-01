package com.example.puntosalexalberto.promos.ui

import com.example.puntosalexalberto.MainNavigation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class PromosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainNavigation()//por ahora se mantiene con una sola navegacion
        }
    }

    override fun onStart() { //estados
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

}

