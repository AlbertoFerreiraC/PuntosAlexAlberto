package com.example.puntosalexalberto.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.puntosalexalberto.R
import com.example.puntosalexalberto.login.model.LoginState
import kotlin.system.exitProcess

@Composable
fun LoginScreem(navController: NavController, loginViewModel: LoginViewModel) {
    val loginState = loginViewModel.loginState.value
    val cedulaState = loginViewModel.cedulaState.value
    val passState = loginViewModel.passState.value

    screen(
        navController,
        loginViewModel,
        cedulaState = cedulaState,
        passState = passState
    )

    when (loginState) {
        is LoginState.Error -> {
            MensajeError(loginState.throwable, onDismiss = { Unit })
        }

        LoginState.Loading -> {
            ProgressBar()
        }

        is LoginState.Success -> {
            if (loginState.state) {
                navController.navigate("ReferenciadosScreem")
            }
        }
    }
}

@Composable
private fun screen(
    navController: NavController,
    loginViewModel: LoginViewModel,
    cedulaState: String,
    passState: String
) {
    MaterialTheme {
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
                ImageAlex()

                OutlineCedula(loginViewModel, cedulaState)

                OutlinePas(loginViewModel, passState)

                Spacer(modifier = Modifier.height(30.dp))

                BotonIngresar(loginViewModel)

                Spacer(modifier = Modifier.height(3.dp))

                BotonRegis(navController)

                Spacer(modifier = Modifier.height(40.dp))

                TextOlvide(navController)
            }
        }
    }
}

@Composable
private fun ImageAlex() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(vertical = 40.dp)
            .padding(horizontal = 10.dp),
        painter = painterResource(id = R.drawable.puntosalex),
        contentDescription = "Puntos Alex"
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OutlineCedula(loginViewModel: LoginViewModel, cedulaState: String) {
    OutlinedTextField(
        value = cedulaState,
        onValueChange = { nextText ->
            loginViewModel.cedula(nextText)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        label = { Text(text = "Cédula de identidad") })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OutlinePas(loginViewModel: LoginViewModel, passState: String) {
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
            loginViewModel.pass(nextText)
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
private fun BotonIngresar(loginViewModel: LoginViewModel) {
    Button(
        //onClick = { navController.navigate("ReferenciadosScreem") },
        onClick = { loginViewModel.login() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red,
            contentColor = Color.White
        ),
        shape = RectangleShape,
        elevation = ButtonDefaults
            .buttonElevation(10.dp),//para sombreado
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        Text(text = "INGRESAR")
    }
}
@Composable
private fun BotonRegis(navController: NavController) {
    Button(
        onClick = {navController.navigate("RegistroScreem")},
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
        Text(text = "REGISTRARME")
    }
}
@Composable
private fun TextOlvide(navController: NavController) {
    val mensajeAlerta = remember { mutableStateOf(false) }
    Text(
        text = "Olvidé mi contraseña",
        fontSize = 15.sp,
        color = Color.Red,
        modifier = Modifier
            .clickable {
                mensajeAlerta.value = true
            }
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        textAlign = TextAlign.Center
    )
    if (mensajeAlerta.value) {
        Alerta(navController)
    }
}
@Composable
private fun Alerta(navController: NavController) {
    AlertDialog(
        onDismissRequest = {
        },
        title = {
            Text(text = "Información")
        },
        text = {
            Text("Comunicate al +595986101152 para recibir una contraseña temporal")
        },
        confirmButton = {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Red
                ),
                onClick = {
                    navController.navigate("LoginScreem")
                }) {
                Text("ACEPTAR")
            }
        },
        dismissButton = {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Red
                ),
                onClick = { exitProcess(0) }//para salir de la app
            ) {
                Text("LLAMAR")
            }
        }
    )
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

