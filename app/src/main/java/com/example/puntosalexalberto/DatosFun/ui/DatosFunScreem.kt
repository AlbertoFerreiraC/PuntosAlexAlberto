package com.example.puntosalexalberto.DatosFun.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
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
import com.example.puntosalexalberto.DatosFun.domain.DatosFunUseCase
import com.example.puntosalexalberto.DatosFun.model.DatosFunState
import com.example.puntosalexalberto.R


@Composable
fun DatosFunScreem(navController: NavController, datosFunViewModel: DatosFunViewModel) {
    val datosFunState = datosFunViewModel.datosFunState.value
    val cedulaState = datosFunViewModel.cedulaState.value
    val celularState = datosFunViewModel.celularState.value

    screen(navController, datosFunViewModel, cedulaState = cedulaState, celularState = celularState)

    when (datosFunState) {
        is DatosFunState.Error -> {
            MensajeError(datosFunState.throwable, onDismiss = { Unit })
        }

        DatosFunState.Loading -> {
            ProgressBar()
        }

        is DatosFunState.Succes -> {
            if (datosFunState.state) {
                //mensaje de aprobacion
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun screen(
    navController: NavController,
    datosFunViewModel: DatosFunViewModel,
    cedulaState: String,
    celularState: String
) {
    Scaffold(topBar = {

        ToolReferidos(navController = navController)

    }) {// Agregar el padding
        Column(
            modifier = Modifier.padding(it)
        ) {
            Cedula(datosFunViewModel, cedulaState)

            Celular(datosFunViewModel, celularState)

            Buton(navController)

            //datosFunUseCase.datos(datosFunViewModel.celularState.value,datosFunViewModel.cedulaState.value)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ToolReferidos(navController: NavController) {
    TopAppBar(title = { Text("Completá tus datos", color = colorResource(id = R.color.white)) },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Red),
        navigationIcon = {
            IconButton(onClick = {navController.navigate("RegistroScreem")}) {
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
private fun Cedula(datosFunViewModel: DatosFunViewModel, cedulaState: String) {
    OutlinedTextField(value = cedulaState, onValueChange = { nextText ->
        datosFunViewModel.cedula(nextText)
    }, modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp), label = {
        Text(text = "Cédula de Identidad")
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Celular(datosFunViewModel: DatosFunViewModel, celularState: String) {
    OutlinedTextField(value = celularState,
        onValueChange = { nextText ->
            datosFunViewModel.celular(nextText)
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp), label = {
            Text(text = "Celular")
        })
}

@Composable
private fun Buton(navController: NavController) {
    Button(
        onClick = {navController.popBackStack()},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red, contentColor = Color.White
        ),
        shape = RectangleShape,
        elevation = ButtonDefaults.buttonElevation(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(text = "SIGUIENTE")
    }
}

@Composable
private fun MensajeError(error: Throwable, onDismiss: () -> Unit) {
    val mensaje = remember { mutableStateOf(true) }
    if (mensaje.value) {
        AlertDialog(onDismissRequest = {
            onDismiss()
            mensaje.value = false
        }, title = {
            Text(text = "Advertencia")
        }, text = {
            Text(text = "${error.message}")
        }, confirmButton = {
            Button(colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent, contentColor = Color.Red
            ), onClick = {
                onDismiss()
                mensaje.value = false
            }) {
                Text("ACEPTAR")
            }
        })
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
            modifier = Modifier.wrapContentSize(), strokeWidth = 4.dp, color = Color.Red
        )
    }
}