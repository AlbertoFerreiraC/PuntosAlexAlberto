package com.example.puntosalexalberto.referidos.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.puntosalexalberto.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReferidosScreem(navController: NavController) {
    val navController = rememberNavController()
    Scaffold(topBar = {

        ToolReferidos(navController)

    }) {// Agregar el padding
        Column(
            modifier = Modifier.padding(it)
        ) {

            Items()

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ToolReferidos(navController: NavController) {
    TopAppBar(title = { Text("REFERIDOS", color = colorResource(id = R.color.white)) },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Red),
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "REFERIDOS",
                    tint = Color.White
                )
            }
        })
}

@Composable
private fun Items() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Greeting(
            texto = "VIGENTE",
            modifier = Modifier
                .background(Color.Unspecified)
        )
        Greeting(
            texto = "HISTORICO",
            modifier = Modifier
                .background(Color.Unspecified)
        )
    }
}
@Composable
fun Greeting(texto: String, modifier: Modifier) {
    Text(text = "$texto",fontSize = 24.sp, modifier = modifier)
}