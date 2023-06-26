package com.example.puntosalexalberto.Registro.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.puntosalexalberto.R
import com.example.puntosalexalberto.referidos.ui.Greeting

@Composable
fun RegistroScreem(navController: NavController) {
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
                    .background(Color.White) //alternativa para no usar un LazyColumn
            ) {
                ImageAlex()

                Texto()

                Butons(navController)

                //Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}

@Composable
private fun ImageAlex() {
    Spacer(modifier = Modifier.height(70.dp))
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(vertical = 40.dp)
            .padding(horizontal = 10.dp),
        painter = painterResource(id = R.drawable.puntosalex),
        contentDescription = "Puntos Alex"
    )
    Spacer(modifier = Modifier.height(55.dp))
}

@Composable
private fun Texto(){
    Text(
        text = "¡Bienvenido!¿Eres funcionario de Alex S.A.?",
        fontSize = 13.sp,
        color = colorResource(id = R.color.black),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.height(50.dp))
}

@Composable
private fun BotonNo(){
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red,
            contentColor = Color.White
        ),
        shape = RectangleShape,
        elevation = ButtonDefaults
            .buttonElevation(15.dp),//para sombreado
        modifier = Modifier
            //.fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        Text(text = "NO")
    }
}

@Composable
private fun BotonSi(navController: NavController){
    Button(
        onClick = {navController.navigate("DatosFunScreem")},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Green,
            contentColor = Color.White
        ),
        shape = RectangleShape,
        elevation = ButtonDefaults
            .buttonElevation(15.dp),//para sombreado
        modifier = Modifier
            //.fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        Text(text = "SI")
    }
}
@Composable
private fun Butons(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BotonSi(navController)
        BotonNo()
    }
}