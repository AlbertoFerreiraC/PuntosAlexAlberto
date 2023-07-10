package com.example.puntosalexalberto.datosUsu.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.puntosalexalberto.DatosFun.ui.DatosFunViewModel
import com.example.puntosalexalberto.R
import com.example.puntosalexalberto.datosUsu.model.DatosUsuState

@Composable
fun DatosUsuScreem(navController: NavController, datosUsuViewModel: DatosUsuViewModel) {
    val datosUsuState = datosUsuViewModel.datosUsuState.value
    val nombreState = datosUsuViewModel.nombreState.value
    val apellidoState = datosUsuViewModel.apellidoState.value
    val celularState = datosUsuViewModel.celularState.value
    val ciFuncionarioState = datosUsuViewModel.ciFuncionarioState.value
    DatosUsu(
        navController,
        datosUsuViewModel,
        nombreState = nombreState,
        apellidoState = apellidoState,
        celularState = celularState,
        ciFuncionarioState = ciFuncionarioState
    )
    when (datosUsuState) {
        is DatosUsuState.Error -> {
            MensajeError(datosUsuState.throwable, onDismiss = { Unit })
        }

        DatosUsuState.Loading -> {
            ProgressBar()
        }

        is DatosUsuState.Success -> {
            if (datosUsuState.state){
                navController.popBackStack()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DatosUsu(
    navController: NavController,
    datosUsuViewModel: DatosUsuViewModel,
    nombreState: String,
    apellidoState: String,
    celularState: String,
    ciFuncionarioState: String
) {
    Scaffold(topBar = {

        Tool(navController)

    }) {
        // Agregar el padding
        Column(
            modifier = Modifier.padding(it)
        ) {
            OutlineNombre(datosUsuViewModel, nombreState)

            OutlineApellido(datosUsuViewModel, apellidoState)

            OutlineCelular(datosUsuViewModel, celularState)

            SpinnerDpto()

            SpinnerLocalidad()

            CedulaFuncionario(datosUsuViewModel, ciFuncionarioState)

            Vinculo()

            ButtonSiguiente()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Tool(navController: NavController) {
    TopAppBar(title = { Text("Completá tus datos", color = colorResource(id = R.color.white)) },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Red),
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
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
private fun OutlineNombre(datosUsuViewModel: DatosUsuViewModel, nombreState: String) {
    OutlinedTextField(value = nombreState, onValueChange = { nextText ->
        datosUsuViewModel.nombre(nextText)
    }, modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp), label = {
        Text(text = "Nombre")
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OutlineApellido(datosUsuViewModel: DatosUsuViewModel, apellidoState: String) {
    OutlinedTextField(value = apellidoState, onValueChange = { nextText ->
        datosUsuViewModel.apellido(nextText)
    }, modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp), label = {
        Text(text = "Apellido")
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OutlineCelular(datosUsuViewModel: DatosUsuViewModel, celularState: String) {
    OutlinedTextField(value = celularState, onValueChange = { nextText ->
        datosUsuViewModel.celular(nextText)
    }, modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp), label = {
        Text(text = "Celular")
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SpinnerDpto() {
    var ExpDepa by remember {
        mutableStateOf(false)
    }
    var expanded by remember { mutableStateOf(false) }
    val depto = listOf("Central", "Amambai", "Capital")
    var selectedOptionText by remember { mutableStateOf(depto[0]) }
    val iconCon = if (ExpDepa) Icons.Filled.KeyboardArrowUp
    else Icons.Filled.KeyboardArrowDown
    ExposedDropdownMenuBox(expanded = ExpDepa, onExpandedChange = {
        expanded = !expanded
    }) {
        OutlinedTextField(value = selectedOptionText,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            label = { Text("Departamento:") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            })
        ExposedDropdownMenu(expanded = expanded, onDismissRequest = {
            expanded = !expanded
        }) {
            depto.forEach { con ->
                DropdownMenuItem(text = {
                    Text(text = con, color = Color.Black)
                }, onClick = {
                    selectedOptionText = con
                    expanded = false
                })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SpinnerLocalidad() {
    var ExpLoc by remember {
        mutableStateOf(false)
    }
    var expanded by remember { mutableStateOf(false) }
    val localidad = listOf("25 De Diciembre", "3 de Febrero", "Abaí")
    var selectedOptionText by remember { mutableStateOf(localidad[0]) }
    val iconCon = if (ExpLoc) Icons.Filled.KeyboardArrowUp
    else Icons.Filled.KeyboardArrowDown
    ExposedDropdownMenuBox(expanded = ExpLoc, onExpandedChange = {
        expanded = !expanded
    }) {
        OutlinedTextField(value = selectedOptionText,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            label = { Text("Localidad:") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            })
        ExposedDropdownMenu(expanded = expanded, onDismissRequest = {
            expanded = !expanded
        }) {
            localidad.forEach { con ->
                DropdownMenuItem(text = {
                    Text(text = con, color = Color.Black)
                }, onClick = {
                    selectedOptionText = con
                    expanded = false
                })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CedulaFuncionario(datosUsuViewModel: DatosUsuViewModel, ciFuncionarioState: String) {
    OutlinedTextField(value = ciFuncionarioState, onValueChange = { nextText ->
        datosUsuViewModel.cifun(nextText)
    }, modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp), label = {
        Text(text = "Cédula del Funcionario de Alex")
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Vinculo() {
    var ExpVinc by remember {
        mutableStateOf(false)
    }
    var expanded by remember { mutableStateOf(false) }
    val vinculo = listOf("PADRE", "MADRE", "HIJO/A", "HERMANO/A", "ESPOSO/A")
    var selectedOptionText by remember { mutableStateOf(vinculo[0]) }
    val iconCon = if (ExpVinc) Icons.Filled.KeyboardArrowUp
    else Icons.Filled.KeyboardArrowDown
    ExposedDropdownMenuBox(expanded = ExpVinc, onExpandedChange = {
        expanded = !expanded
    }) {
        OutlinedTextField(value = selectedOptionText,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            label = { Text("Vinculo con Funcionario:") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            })
        ExposedDropdownMenu(expanded = expanded, onDismissRequest = {
            expanded = !expanded
        }) {
            vinculo.forEach { con ->
                DropdownMenuItem(text = {
                    Text(text = con, color = Color.Black)
                }, onClick = {
                    selectedOptionText = con
                    expanded = false
                })
            }
        }
    }
}

@Composable
private fun ButtonSiguiente() {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red, contentColor = Color.White
        ),
        shape = RectangleShape,
        elevation = ButtonDefaults.buttonElevation(10.dp), // Para sombreado
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 130.dp)
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
