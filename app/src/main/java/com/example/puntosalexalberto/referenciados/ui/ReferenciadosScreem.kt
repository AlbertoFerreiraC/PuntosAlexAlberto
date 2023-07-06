package com.example.puntosalexalberto.referenciados.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.puntosalexalberto.Componentes.DrawerContent
import com.example.puntosalexalberto.R
import com.example.puntosalexalberto.referenciados.model.ReferenciadosState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReferenciadosScreem(
    navController: NavController,
    referenciadosViewModel: ReferenciadosViewModel
) {
    val referenciadosState = referenciadosViewModel.referenciadosState.value
    val articulosState = referenciadosViewModel.articuloState.value
    val nroDocState = referenciadosViewModel.nroDocState.value
    val nombresState = referenciadosViewModel.nombresState.value
    val apellidosState = referenciadosViewModel.apellidoState.value
    val celularState = referenciadosViewModel.celularState.value
    val contactoState = referenciadosViewModel.contactoState.value
    val horarioState = referenciadosViewModel.horarioState.value

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerContent = { DrawerContent(navController as NavHostController, drawerState) },
        drawerState = drawerState,
        scrimColor = Color.Transparent,
    ) {
        Scaffold(topBar = {
            toolbar(drawerState = drawerState)
        }) {
            Box(modifier = Modifier.padding(it)) {
                PantallaReferenciados(
                    referenciadosViewModel,
                    articulosState,
                    nroDocState,
                    nombresState,
                    apellidosState,
                    celularState,
                    contactoState,
                    horarioState
                )
            }
        }
    }
    when (referenciadosState) {
        is ReferenciadosState.Error -> {
            MensajeError(referenciadosState.throwable, onDismiss = { Unit })
        }

        ReferenciadosState.Loading -> {
            ProgressBar()
        }

        is ReferenciadosState.Success -> {
            if (referenciadosState.state) {
                EnviadoCorrectamente(onDismiss = { Unit })
            }
        }
    }
}

@Composable
private fun PantallaReferenciados(
    referenciadosViewModel: ReferenciadosViewModel,
    articulosState: String,
    nroDocState: String,
    nombresState: String,
    apellidosState: String,
    celularState: String,
    contactoState: String,
    horarioState: String
) {
    Column {
        MaterialTheme() {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .verticalScroll(rememberScrollState())
                ) {
                    //componenet de articulo
                    OutlineArticulos(referenciadosViewModel, articulosState)

                    //componenet de nro documento
                    OtlineNroDoc(referenciadosViewModel, nroDocState)

                    //componenet de Nombre
                    OutlineNombre(referenciadosViewModel, nombresState)

                    //componenet de Apellido
                    OutlineApellido(referenciadosViewModel, apellidosState)

                    //componenet de Celular
                    OutlineCel(referenciadosViewModel, celularState)

                    //Componente de forma de contacto
                    SpinnerFormaCon(referenciadosViewModel, contactoState)

                    //Componente de horario disponible
                    SpineerHorario(referenciadosViewModel, horarioState)

                    //Componente de boton enviar
                    ButtonEnviar(referenciadosViewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun toolbar(drawerState: DrawerState) {
    val coroutineScope = rememberCoroutineScope()
    TopAppBar(title = {
        Text(
            "PUNTOS ALEX", color = colorResource(id = R.color.white)
        )
    },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Red),
        navigationIcon = {
            IconButton(onClick = {
                if (drawerState.isClosed) {
                    coroutineScope.launch {
                        drawerState.open()
                    }
                } else {
                    coroutineScope.launch {
                        drawerState.close()
                    }
                }
            }) {
                Icon(
                    Icons.Filled.Menu, contentDescription = "PUNTOS ALEX", tint = Color.White
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OutlineArticulos(
    referenciadosViewModel: ReferenciadosViewModel,
    articulosState: String
) {
    OutlinedTextField(value = articulosState, onValueChange = { nextText ->
        referenciadosViewModel.articulo(nextText)
    }, modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp), label = {
        Text(text = "Articulo de Interés")
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OtlineNroDoc(referenciadosViewModel: ReferenciadosViewModel, nroDocState: String) {
    OutlinedTextField(value = nroDocState, onValueChange = { nextText ->
        referenciadosViewModel.nroDoc(nextText)
    }, modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp), label = {
        Text(text = "Nro. Documento (Opcional)")
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OutlineNombre(referenciadosViewModel: ReferenciadosViewModel, nombresState: String) {
    OutlinedTextField(value = nombresState, onValueChange = { nextText ->
        referenciadosViewModel.nombres(nextText)
    }, modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp), label = {
        Text(text = "Nombres")
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OutlineApellido(
    referenciadosViewModel: ReferenciadosViewModel,
    apellidosState: String
) {
    OutlinedTextField(value = apellidosState, onValueChange = { nextText ->
        referenciadosViewModel.apellidos(nextText)
    }, modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp), label = {
        Text(text = "Apellidos")
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OutlineCel(referenciadosViewModel: ReferenciadosViewModel, celularState: String) {
    OutlinedTextField(value = celularState, onValueChange = { nextText ->
        referenciadosViewModel.celular(nextText)
    }, modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp), label = {
        Text(text = "Celular")
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SpinnerFormaCon(referenciadosViewModel: ReferenciadosViewModel, contactoState: String) {
    var ExpContac by remember {
        mutableStateOf(false)
    }
    var expanded by remember { mutableStateOf(false) }
    val contacto = listOf("WhatsApp", "Llamada")
    var selectedOptionText by remember { mutableStateOf(contacto[0]) }
    val iconCon = if (ExpContac) Icons.Filled.KeyboardArrowUp
    else Icons.Filled.KeyboardArrowDown
    ExposedDropdownMenuBox(expanded = ExpContac, onExpandedChange = {
        expanded = !expanded
    }) {
        OutlinedTextField(value = selectedOptionText,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            label = { Text("Formato de Contacto") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            })
        ExposedDropdownMenu(expanded = expanded, onDismissRequest = {
            expanded = !expanded
        }) {
            contacto.forEach { con ->
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
private fun SpineerHorario(referenciadosViewModel: ReferenciadosViewModel, horarioState: String) {
    var ExpHora by remember { mutableStateOf(false) }
    val horario = (listOf("Indistinto", "Mañana", "Tarde", "Noche"))
    var expHora by remember { mutableStateOf(false) }
    var selectedhorarioText by remember { mutableStateOf(horario[0]) }
    val iconHora = if (ExpHora) Icons.Filled.KeyboardArrowUp
    else Icons.Filled.KeyboardArrowDown

    ExposedDropdownMenuBox(expanded = expHora, onExpandedChange = {
        expHora = !expHora
    }) {
        OutlinedTextField(value = selectedhorarioText,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            label = { Text("Horario Disponible") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expHora
                )
            })
        ExposedDropdownMenu(expanded = expHora, onDismissRequest = {
            expHora = !expHora
        }) {
            horario.forEach { hora ->
                DropdownMenuItem(text = {
                    Text(text = hora, color = Color.Black)
                }, onClick = {
                    selectedhorarioText = hora
                    expHora = false
                })
            }
        }
    }
}

@Composable
private fun ButtonEnviar(referenciadosViewModel: ReferenciadosViewModel) {
    Button(
        onClick = { referenciadosViewModel.referenciar() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red, contentColor = Color.White
        ),
        shape = RectangleShape,
        elevation = ButtonDefaults.buttonElevation(10.dp), // Para sombreado
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        Text(text = "ENVIAR")
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

@Composable
private fun EnviadoCorrectamente(onDismiss: () -> Unit) {
    val mensaje = remember { mutableStateOf(true) }
    if (mensaje.value) {
        AlertDialog(
            onDismissRequest = {
                onDismiss()
                mensaje.value = false
            },
            title = {
                Text(text = "Atención")
            },
            text = {
                Text(text = "Referenciado cargado con éxito")
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
