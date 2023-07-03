package com.example.puntosalexalberto.RegisUsu.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.puntosalexalberto.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisUsu(navController: NavController, regisUsuViewModel: RegisUsuViewModel) {
    Scaffold(topBar = {

        ToolPromo(navController)

    }) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Cedula()

            Button(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ToolPromo(navController: NavController) {
    TopAppBar(title = { Text("Completá tus datos", color = colorResource(id = R.color.white)) },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Red),
        navigationIcon = {
            IconButton(onClick = { navController.navigate("RegistroScreem") }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Completá tus datos",
                    tint = Color.White
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Cedula() {
    var nroDoc by remember {
        mutableStateOf("")
    }
    OutlinedTextField(value = nroDoc, onValueChange = { nextText ->
        nroDoc = nextText
    }, modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp), label = {
        Text(text = "Cédula de Identidad")
    })
}

@Composable
private fun Button(navController: NavController) {
    Button(
        onClick = { navController.navigate("LoginScreen") },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red, contentColor = Color.White
        ),
        shape = RectangleShape,
        elevation = ButtonDefaults.buttonElevation(10.dp),
        modifier = Modifier
            .wrapContentWidth()
            .padding(10.dp)
    ) {
        Text(text = "SIGUIENTE")
    }
}