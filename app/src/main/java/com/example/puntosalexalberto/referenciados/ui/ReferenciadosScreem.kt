package com.example.puntosalexalberto.referenciados.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReferenciadosScreem(navController: NavController) { // Agrega el parámetro navController
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
                PantallaReferenciados()
            }
        }
    }
}

@Composable
fun PantallaReferenciados() {
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
                    OutlineArticulos()

                    //componenet de nro documento
                    OtlineNroDoc()

                    //componenet de Nombre
                    OutlineNombre()

                    //componenet de Apellido
                    OutlineApellido()

                    //componenet de Celular
                    OutlineCel()

                    //Componente de forma de contacto
                    SpinnerFormaCon()

                    //Componente de horario disponible
                    SpineerHorario()

                    //Componente de boton enviar
                    ButtonEnviar()
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
private fun OutlineArticulos() {
    var articulo by remember {
        mutableStateOf("")
    }
    OutlinedTextField(value = articulo, onValueChange = { nextText ->
        articulo = nextText
    }, modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp), label = {
        Text(text = "Articulo de Interés")
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OtlineNroDoc() {
    var nroDoc by remember {
        mutableStateOf("")
    }
    OutlinedTextField(value = nroDoc, onValueChange = { nextText ->
        nroDoc = nextText
    }, modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp), label = {
        Text(text = "Nro. Documento (Opcional)")
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OutlineNombre() {
    var nombre by remember {
        mutableStateOf("")
    }
    OutlinedTextField(value = nombre, onValueChange = { nextText ->
        nombre = nextText
    }, modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp), label = {
        Text(text = "Nombres")
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OutlineApellido() {
    var apellido by remember {
        mutableStateOf("")
    }
    OutlinedTextField(value = apellido, onValueChange = { nextText ->
        apellido = nextText
    }, modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp), label = {
        Text(text = "Apellidos")
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OutlineCel() {
    var cel by remember {
        mutableStateOf("")
    }
    OutlinedTextField(value = cel, onValueChange = { nextText ->
        cel = nextText
    }, modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp), label = {
        Text(text = "Celular")
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SpinnerFormaCon() {
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
private fun SpineerHorario() {
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
private fun ButtonEnviar() {
    Button(
        onClick = { },
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