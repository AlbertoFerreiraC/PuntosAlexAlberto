package com.example.puntosalexalberto.contraseña.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.puntosalexalberto.R
import com.example.puntosalexalberto.contraseña.model.ContrasenaState

@Composable
fun ContrasenaScreem(
    navController: NavController,
    contrasenaViewModel: ContrasenaViewModel
) {
    val contrasenaState = contrasenaViewModel.contrasenaState.value
    val passState = contrasenaViewModel.passState.value
    val passVisi = contrasenaViewModel.passVisiState.value

    ContrasenaPantalla(
        navController,
        contrasenaViewModel,
        passState = passState,
        passVisi = passVisi
    )
    when (contrasenaState) {
        is ContrasenaState.Error -> {
            MensajeError(contrasenaState.throwable, onDismiss = { Unit })
        }

        ContrasenaState.Loading -> {
            ProgressBar()
        }

        is ContrasenaState.Success -> {
            if (contrasenaState.state) {
                navController.navigate("LoginScreem")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ContrasenaPantalla(
    navController: NavController,
    contrasenaViewModel: ContrasenaViewModel,
    passState: String,
    passVisi: String
) {
    Scaffold(topBar = {

        Tool(navController)

    }) {
        // Agregar el padding
        Column(
            modifier = Modifier.padding(it)
        ) {
            Contrasena(contrasenaViewModel, passState)
            RepContrasena(contrasenaViewModel, passVisi)
            ButtonAceptar(contrasenaViewModel)
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
private fun Contrasena(contrasenaViewModel: ContrasenaViewModel, passState: String) {
    var paswVisible by remember {
        mutableStateOf(false)
    }
    val icon = if (paswVisible) {
        painterResource(id = R.drawable.desing_ic_visibility)
    } else {
        painterResource(id = R.drawable.desing_ic_visibilityoff)
    }
    OutlinedTextField(
        value = passState,
        onValueChange = { nextText ->
            contrasenaViewModel.pass(nextText)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        label = { Text(text = "Contraseña") },
        trailingIcon = {
            IconButton(onClick = {
                paswVisible = !paswVisible
            }) {
                Icon(
                    painter = icon,
                    contentDescription = "Ver contraseña"
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = if (paswVisible) VisualTransformation.None
        else PasswordVisualTransformation()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RepContrasena(contrasenaViewModel: ContrasenaViewModel, passVisi: String) {
    var paswVisible by remember {
        mutableStateOf(false)
    }
    val icon = if (paswVisible) {
        painterResource(id = R.drawable.desing_ic_visibility)
    } else {
        painterResource(id = R.drawable.desing_ic_visibilityoff)
    }
    OutlinedTextField(
        value = passVisi,
        onValueChange = { nextText ->
            contrasenaViewModel.passVisi(nextText)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        label = { Text(text = "Contraseña") },
        trailingIcon = {
            IconButton(onClick = {
                paswVisible = !paswVisible
            }) {
                Icon(
                    painter = icon,
                    contentDescription = "Ver contraseña"
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = if (paswVisible) VisualTransformation.None
        else PasswordVisualTransformation()
    )
}

@Composable
private fun ButtonAceptar(contrasenaViewModel: ContrasenaViewModel) {
    Button(
        onClick = { contrasenaViewModel.passState },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Red
        ),
        shape = RectangleShape,
        elevation = ButtonDefaults
            .buttonElevation(10.dp),//para sombreado
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        Text(text = "ACEPTAR")
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
