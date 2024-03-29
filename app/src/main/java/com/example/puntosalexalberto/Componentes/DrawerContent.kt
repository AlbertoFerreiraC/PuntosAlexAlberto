package com.example.puntosalexalberto.Componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerContent(navController: NavHostController, drawerState: DrawerState) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 53.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        DrawerHeader()
        Spacer(modifier = Modifier.height(10.dp))
        Divider(color = Color.LightGray)
        Spacer(modifier = Modifier.height(10.dp))
        NavigationDrawerItems(navController, drawerState)
        Spacer(modifier = Modifier.weight(1f))

        TextoMira()

        TextoWeb()
    }
}

@Composable
private fun TextoMira() {
    Text(
        text = "Mirá cuántos puntos tenés y canjeá en: ",
        fontSize = 16.sp,
    )
}

@Composable
private fun TextoWeb() {
    Text(
        text = "www.puntosalex.com.py",
        fontSize = 16.sp,
        color = Color.Red,
        modifier = Modifier
            .clickable {
                // showDialog.value = true
            }
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        textAlign = TextAlign.Center
    )
    /* if (showDialog.value) {
        // Alerta(navController)
     }*/
}

