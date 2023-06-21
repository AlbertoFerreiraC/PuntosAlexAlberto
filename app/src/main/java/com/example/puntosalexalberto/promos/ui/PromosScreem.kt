package com.example.puntosalexalberto.promos.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.puntosalexalberto.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun PromosScreem() {
    Scaffold(topBar = {
        TopAppBar(title = { Text("PROMOS", color = colorResource(id = R.color.white)) },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Red),
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "PROMOS",
                        tint = Color.White
                    )
                }
            })
    }) {
        // Agregar el padding
        Column(
            modifier = Modifier.padding(it)
        ) {

        }
    }
}