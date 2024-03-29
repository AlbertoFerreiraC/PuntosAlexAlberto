package com.example.puntosalexalberto.promos.ui

import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.example.puntosalexalberto.R
import com.example.puntosalexalberto.promos.domain.PromosUseCase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PromosScreem(
    navController: NavController,
    promosViewModel: PromosViewModel,
    promosUseCase: PromosUseCase
) {
    Scaffold(topBar = {

        ToolPromo(navController)

    }) {
        // Agregar el padding
        Column(
            modifier = Modifier.padding(it)
        ) {
            val imagePainter: Painter = promosUseCase.img()
            Image(painter = imagePainter, contentDescription = "Imagen de prueba") //puede tener valores

            val imagen: Painter = promosUseCase.imagen()
            Image(painter = imagen, contentDescription = null) //puede ser nulo
            
            val texto: Int = promosUseCase.texto()
            Text(text = texto)
        }
    }
}

fun Text(text: Int) {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ToolPromo(navController: NavController){
        TopAppBar(title = { Text("PROMOS", color = colorResource(id = R.color.white)) },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Red),
            navigationIcon = {
                IconButton(onClick = {navController.popBackStack()}) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "PROMOS",
                        tint = Color.White
                    )
                }
            }
        )
}