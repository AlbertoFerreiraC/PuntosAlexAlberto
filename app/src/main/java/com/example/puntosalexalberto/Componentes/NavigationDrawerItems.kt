package com.example.puntosalexalberto.Componentes

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawerItems(navController: NavHostController, drawerState: DrawerState) {

    var scope = rememberCoroutineScope()

    var currentBackStackEntryAsState = navController.currentBackStackEntryAsState()

    var destination = currentBackStackEntryAsState.value?.destination

    NavigationDrawerItem(
        icon = { Icon(Icons.Filled.Person, contentDescription = "Referidos") },
        label = { Text(text = "Referidos") },
        selected = destination?.route == "ReferidosScreem",
        onClick = {
            navController.navigate("ReferidosScreem", navOptions {
                this.launchSingleTop = true
                this.restoreState = true

            })
            scope.launch {
                drawerState.close()
            }

        },
        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
    )

    Spacer(modifier = Modifier.height(10.dp))
    NavigationDrawerItem(
        icon = { Icon(Icons.Filled.ShoppingCart, "Catálogo Alex") },
        label = { Text(text = "Catálogo Alex") },
        selected = destination?.route == "PromosScreem",

        onClick = {
            navController.navigate("PromosScreem", navOptions {
                this.launchSingleTop = true
                this.restoreState = true

            })
            scope.launch {
                drawerState.close()
            }
        },
        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
    )
    Spacer(modifier = Modifier.height(10.dp))


    NavigationDrawerItem(
        icon = { Icon(Icons.Filled.Close, "Cerrar Sesión") },

        label = { Text(text = "Cerrar Sesión") },
        selected = destination?.route == "LoginScreem",
        onClick = {
            navController.navigate("LoginScreem", navOptions {
                this.launchSingleTop = true
                this.restoreState = true
            })
            scope.launch {
                drawerState.close()
            }
        },
        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
    )


}