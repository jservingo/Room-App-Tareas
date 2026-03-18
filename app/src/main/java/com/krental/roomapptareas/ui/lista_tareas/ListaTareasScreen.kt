package com.krental.roomapptareas.ui.lista_tareas

import android.R.attr.label
import android.R.attr.text
import android.R.attr.value
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.krental.roomapptareas.ui.viewmodel.TareaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaTareasScreen(
    viewModel: TareaViewModel = hiltViewModel(),
    navController: NavController
){
    val tareas by viewModel.tareas.collectAsState()

    var query by remember { mutableStateOf("") }
    val tareasFiltradas by viewModel.tareasFiltradas.collectAsState()
    val tareasAmostrar = if (query.isEmpty()) tareas else tareasFiltradas

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Lista de Tareas") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("pantallaAgregarTarea/${query}")
                }
            ){
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar"
                )
            }
        }
    ){ paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ){
            //Campo de texto para buscar tareas
            OutlinedTextField(
                value = query,
                onValueChange = {
                    query = it
                    viewModel.buscarTareas(query)
                },
                label = { Text(text = "Buscar por titulo o descripcion") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (tareasAmostrar.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "No hay tareas registras. Agrega una nueva")
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    items(tareasAmostrar) { tarea ->
                        TareaItem(
                            tarea = tarea,
                            onEliminarClick = { tareaSeleccionada ->
                                viewModel.eliminarTarea(tareaSeleccionada, query)
                            },
                            onEditarClick = { tareaSeleccionada ->
                                navController.navigate("editarTareaScreen/${tareaSeleccionada.id}")
                            },
                            onVerDetalleClick = { tareaSeleccionada ->
                                navController.navigate("detalle/${tareaSeleccionada.id}")
                            }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}