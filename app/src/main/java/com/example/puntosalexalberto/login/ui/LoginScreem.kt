package com.example.puntosalexalberto.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.puntosalexalberto.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun LoginScreem() {
    var ci by remember {
        mutableStateOf("")
    }
    var pasw by remember {
        mutableStateOf("")
    }
    var paswVisible by remember {
        mutableStateOf(false)
    }

    val icon = if (paswVisible) {
        painterResource(id = R.drawable.desing_ic_visibility)
    } else {
        painterResource(id = R.drawable.desing_ic_visibilityoff)
    }
    val navController = rememberNavController()
    MaterialTheme {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column( //para tener un scrol en columnas no funciona sin un item
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .verticalScroll(rememberScrollState()) //alternativa para no usar un LazyColumn
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(vertical = 40.dp)
                        .padding(horizontal = 10.dp),
                    painter = painterResource(id = R.drawable.puntosalex),
                    contentDescription = "Puntos Alex"
                )
                // Spacer(modifier = Modifier.height(10.dp))
                //ingresar cedula
                OutlinedTextField(value = ci, onValueChange = { nextText ->
                    ci = nextText
                },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    label = { Text(text = "Cédula de identidad") })
                //ingresar contraseña
                OutlinedTextField(
                    value = pasw, onValueChange = { nextText ->
                        pasw = nextText
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
                Spacer(modifier = Modifier.height(30.dp))
                //boton de ingresar
                Button(
                    onClick = { navController.navigate("com.example.puntosalexalberto.referenciados.ui.ReferenciadosScreem") },
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
                Spacer(modifier = Modifier.height(3.dp))
                //boton de registrarse
                Button(
                    onClick = { },
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
                Spacer(modifier = Modifier.height(40.dp))
                //olvide mi contraseña
                Text( //texto centrado en el medio de la pantalla
                    text = "Olvidé mi contraseña",
                    fontSize = 15.sp, //tamaño del texto
                    //color = Color.Red, //color del texto
                    color = colorResource(id = R.color.red),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp), //ocupa el espacio con imagen
                    textAlign = TextAlign.Center //alinea el texto
                )
            }
        }
    }
}