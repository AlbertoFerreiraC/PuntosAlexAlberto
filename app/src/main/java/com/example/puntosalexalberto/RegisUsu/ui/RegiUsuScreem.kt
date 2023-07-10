package com.example.puntosalexalberto.RegisUsu.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.puntosalexalberto.R
import com.example.puntosalexalberto.RegisUsu.model.RegisUsuState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisUsu(
    navController: NavController, regisUsuViewModel: RegisUsuViewModel
) {
    val regisUsuState = regisUsuViewModel.regisUsuState.value
    val cedulaState = regisUsuViewModel.cedulaState.value

    RegisUsuScreem(
        navController,
        regisUsuViewModel,
        cedulaState = cedulaState
    )
    when (regisUsuState) {
        is RegisUsuState.Error -> {
            MensajeError(regisUsuState.throwable, onDismiss = { Unit })
        }

        RegisUsuState.Loading -> {
            ProgressBar()
        }

        is RegisUsuState.Success -> {
            if (regisUsuState.state){
                navController.navigate("LoginScreem")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RegisUsuScreem(
    navController: NavController,
    regisUsuViewModel: RegisUsuViewModel,
    cedulaState: String
) {
    Scaffold(topBar = {

        ToolPromo(navController)

    }) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Cedula(regisUsuViewModel, cedulaState)

            Button(regisUsuViewModel)
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
private fun Cedula(regisUsuViewModel: RegisUsuViewModel, cedulaState: String) {
    OutlinedTextField(value = cedulaState, onValueChange = { nextText ->
        regisUsuViewModel.cedula(nextText)
    }, modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp), label = {
        Text(text = "Cédula de Identidad")
    })
}

@Composable
private fun Button(regisUsuViewModel: RegisUsuViewModel) {
    Button(
        onClick = { regisUsuViewModel.regisUsuario() },
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


@Composable
private fun MensajeError(error: Throwable, onDismiss: () -> Unit) {
    val mensaje = remember { mutableStateOf(true) }
    if (mensaje.value) {
        AlertDialog(
            onDismissRequest = {
                onDismiss()
                mensaje.value = false
            },
            title = {
                Text(text = "Advertencia")
            },
            text = {
                Text(text = "${error.message}")
            },
            confirmButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Red
                    ),
                    onClick = {
                        onDismiss()
                        mensaje.value = false
                    }
                ) {
                    Text("ACEPTAR")
                }
            }
        )
    }
}

@Composable
private fun ProgressBar() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.wrapContentSize(),
            strokeWidth = 4.dp,
            color = Color.Red
        )
    }
}

