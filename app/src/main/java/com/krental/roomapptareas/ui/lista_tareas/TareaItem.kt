package com.krental.roomapptareas.ui.lista_tareas

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.krental.roomapptareas.data.local.entity.TareaEntity
import androidx.compose.ui.graphics.Color

@Composable
fun TareaItem(
    tarea: TareaEntity,
    onEliminarClick: (TareaEntity) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ){
        Box(
            modifier = Modifier.fillMaxWidth()
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = tarea.titulo,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = tarea.descripcion ?: "Sin descripción",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Creada: ${tarea.fechaCreacion}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            IconButton(
                onClick = { onEliminarClick(tarea) },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
            ){
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar tarea",
                    tint = Color.Red
                )
            }
        }
    }
}