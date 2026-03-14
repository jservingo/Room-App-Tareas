package com.krental.roomapptareas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.krental.roomapptareas.ui.agregar_tarea.AgregarTareaScreen
import com.krental.roomapptareas.ui.lista_tareas.ListaTareasScreen

@Composable
fun AppNavigation(
    navController : NavHostController
){
    NavHost(
        navController = navController,
        startDestination = "pantallaListaTareas"
    ){
        composable(route = "pantallaAjustes") {
            //AjustesScreen(navController = navController)
        }
        composable(route = "pantallaListaTareas") {
            ListaTareasScreen(navController = navController)
        }
        composable(route = "pantallaAgregarTarea") {
            AgregarTareaScreen(navController = navController)
        }
        composable(
            route = "editarTareaScreen/{tareaId}",
            arguments = listOf(navArgument("tareaId"){type = NavType.IntType})
        ) { navBackStackEntry ->
            val tareaId = navBackStackEntry.arguments?.getInt("tareaId") ?: 0
            /*
            EditarTareaScreen(
                navController = navController,
                tareaId = tareaId
            )
             */
        }
        composable(
            route = "detalle/{id}") {  navBackStackEntry ->
            val tareaId = navBackStackEntry.arguments?.getString("id")?.toIntOrNull() ?: return@composable
            /*
            DetalleTareaScreen(
                tareaId = tareaId,
                navController = navController
            )
             */
        }
    }
}