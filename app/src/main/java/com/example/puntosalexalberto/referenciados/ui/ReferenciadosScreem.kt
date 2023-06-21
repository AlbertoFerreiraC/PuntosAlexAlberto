package com.example.puntosalexalberto.referenciados.ui

import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.puntosalexalberto.Componentes.DrawerContent
import com.example.puntosalexalberto.R
import com.example.puntosalexalberto.login.ui.LoginScreem
import com.example.puntosalexalberto.promos.ui.PromosScreem
import com.example.puntosalexalberto.referidos.ui.ReferidosScreem
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ReferenciadosScreem() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = { DrawerContent(navController, drawerState) },
        drawerState = drawerState,
        scrimColor = Color.Transparent,
    ) {
        Scaffold(
            topBar = {
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
                                Icons.Filled.Menu,
                                contentDescription = "PUNTOS ALEX",
                                tint = Color.White
                            )
                        }
                    })
            }) {

            NavHost(navController = navController, startDestination = "ReferidosScreem") {
                composable("ReferidosScreem") {
                    ReferidosScreem()
                }
                composable("CatalogoScreem") {
                    PromosScreem()
                }
                composable("SettingPage") {
                    LoginScreem()
                }

            }

            // Agregar el padding
            Column(
                modifier = Modifier.padding(it)
            ) {
                var ExpContac by remember {
                    mutableStateOf(false)
                }
                var ExpHora by remember {
                    mutableStateOf(false)
                }
                var articulo by remember {
                    mutableStateOf("")
                }
                var nroDoc by remember {
                    mutableStateOf("")
                }
                var nombre by remember {
                    mutableStateOf("")
                }
                var apellido by remember {
                    mutableStateOf("")
                }
                var cel by remember {
                    mutableStateOf("")
                }
                // Para el spinner
                val contacto = listOf("WhatsApp", "Llamada")

                var expanded by remember { mutableStateOf(false) }
                var selectedOptionText by remember { mutableStateOf("") }
                val iconCon = if (ExpContac) Icons.Filled.KeyboardArrowUp
                else Icons.Filled.KeyboardArrowDown

                val horario = (listOf("Indistinto", "Mañana", "Tarde", "Noche"))

                var expHora by remember { mutableStateOf(false) }
                var selectedhorarioText by remember { mutableStateOf(horario[0]) }
                val iconHora = if (ExpHora) Icons.Filled.KeyboardArrowUp
                else Icons.Filled.KeyboardArrowDown

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
                                .verticalScroll(rememberScrollState()) // Alternativa para no usar un LazyColumn
                        ) {
                            OutlinedTextField(value = articulo,
                                onValueChange = { nextText ->
                                    articulo = nextText
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp),
                                label = {
                                    Text(text = "Articulo de Interés")
                                })
                            OutlinedTextField(value = nroDoc,
                                onValueChange = { nextText ->
                                    nroDoc = nextText
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp),
                                label = {
                                    Text(text = "Nro. Documento (Opcional)")
                                })
                            OutlinedTextField(value = nombre,
                                onValueChange = { nextText ->
                                    nombre = nextText
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp),
                                label = {
                                    Text(text = "Nombres")
                                })
                            OutlinedTextField(value = apellido,
                                onValueChange = { nextText ->
                                    apellido = nextText
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp),
                                label = {
                                    Text(text = "Apellidos")
                                })
                            OutlinedTextField(value = cel,
                                onValueChange = { nextText ->
                                    cel = nextText
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp),
                                label = {
                                    Text(text = "Celular")
                                })

                            //Contacto
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
                            //horario
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
                    }
                }
            }
        }
    }

}
