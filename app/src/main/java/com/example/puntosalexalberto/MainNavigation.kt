package com.example.puntosalexalberto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.puntosalexalberto.Componentes.DrawerContent
import com.example.puntosalexalberto.DatosFun.ui.DatosFunScreem
import com.example.puntosalexalberto.RegisUsu.ui.RegisUsu
import com.example.puntosalexalberto.Registro.ui.RegistroScreem
import com.example.puntosalexalberto.login.ui.LoginScreem
import com.example.puntosalexalberto.login.ui.LoginViewModel
import com.example.puntosalexalberto.promos.ui.PromosScreem
import com.example.puntosalexalberto.referenciados.ui.ReferenciadosScreem
import com.example.puntosalexalberto.referidos.ui.ReferidosScreem

class MainNavigation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavegacionMain()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NavegacionMain() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navController = rememberNavController()
    val loginViewModel = LoginViewModel()
    ModalNavigationDrawer(
        drawerContent = { DrawerContent(navController, drawerState) },
        drawerState = drawerState
    ) {
        NavHost(navController = navController, startDestination = "LoginScreem") {
            composable("ReferenciadosScreem") {
                ReferenciadosScreem(navController)
            }
            composable("ReferidosScreem") {
                ReferidosScreem(navController)
            }
            composable("PromosScreem") {
                PromosScreem(navController)
            }
            composable("LoginScreem") {
                LoginScreem(navController, loginViewModel)
            }
            composable("RegistroScreem") {
                RegistroScreem(navController)
            }
            composable("DatosFunScreem") {
                DatosFunScreem(navController)
            }
            composable("RegisUsuScreem") {
                RegisUsu(navController)
            }
        }
    }
}