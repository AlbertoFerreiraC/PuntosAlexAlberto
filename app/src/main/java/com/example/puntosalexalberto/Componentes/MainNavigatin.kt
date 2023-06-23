package com.example.puntosalexalberto.Componentes

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.puntosalexalberto.login.ui.LoginScreem
import com.example.puntosalexalberto.promos.ui.PromosScreem
import com.example.puntosalexalberto.referenciados.ui.ReferenciadosScreem
import com.example.puntosalexalberto.referidos.ui.ReferidosScreem

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MainNavigation() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navController = rememberNavController()
    ModalNavigationDrawer(
        drawerContent = { DrawerContent(navController, drawerState) },
        drawerState = drawerState
    ) {
        NavHost(navController = navController, startDestination = "Inicial") {
            composable("Inicial") {
                ReferenciadosScreem()
            }
            composable("ReferenciadosScreem") {
                ReferenciadosScreem()
            }
            composable("ReferidosScreem") {
                ReferidosScreem()
            }
            composable("PromosScreem") {
                PromosScreem()
            }
        }
    }
}