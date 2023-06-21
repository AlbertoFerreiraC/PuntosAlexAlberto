package com.example.puntosalexalberto.Componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalUnitApi::class)
@Preview
@Composable
fun DrawerHeader() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Image(
            painter = painterResource(id = com.example.puntosalexalberto.R.drawable.puntosalex),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Puntos Alex", color = Color.Black,)
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = "5709765@alexsa.com.py", fontSize = TextUnit(14F, TextUnitType.Sp), color = Color.Black)




    }

}