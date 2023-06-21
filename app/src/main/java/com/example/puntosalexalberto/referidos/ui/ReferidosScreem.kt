package com.example.puntosalexalberto.referidos.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.puntosalexalberto.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ReferidosScreem() {
    Scaffold(topBar = {
        TopAppBar(title = { Text("REFERIDOS", color = colorResource(id = R.color.white)) },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Red),
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "REFERIDOS",
                        tint = Color.White
                    )
                }
            })
    }) {
        // Agregar el padding
        Column(
            modifier = Modifier.padding(it)
        ) {
            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp) //fillMaxWidth que maximise tamaño. Padding para que no este pégado al borde

            ) {
                item {
                    Text(
                        text = "VIGENTE ", color = Color.Black, fontSize = 20.sp
                    )
                    Text(
                        text = "HISTORICO", color = Color.Black, fontSize = 20.sp
                    )
                }
            }
        }
    }
}