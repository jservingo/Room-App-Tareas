package com.krental.roomapptareas.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.krental.roomapptareas.data.local.entity.TareaEntity
import com.krental.roomapptareas.data.repositorio.TareaRepositorio
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TareaViewModel @Inject constructor(
    private val repository: TareaRepositorio
) : ViewModel() {

    private val _tareas = MutableStateFlow<List<TareaEntity>>(emptyList())
    val tareas: StateFlow<List<TareaEntity>> = _tareas

    private val _tarea_seleccionada = MutableStateFlow<TareaEntity?>(null)
    val tareaSeleccionada : StateFlow<TareaEntity?> = _tarea_seleccionada

    init {
        viewModelScope.launch {
            repository.obtenerTodasLasTareas().collect {
                _tareas.value = it
            }
        }
    }

    fun insertarTarea(tarea: TareaEntity) {
        viewModelScope.launch {
            repository.insertarTarea(tarea)
        }
    }

    fun eliminarTarea(tarea: TareaEntity) {
        viewModelScope.launch {
            repository.eliminarTarea(tarea)
        }
    }

    fun actualizarTarea(tarea: TareaEntity) {
        viewModelScope.launch {
            repository.actualizarTarea(tarea)
        }
    }

    fun cargarTareaPorId(id: Int) {
        viewModelScope.launch {
            val tarea = repository.obtenerTareaPorId(id)
            Log.d("ID", tarea?.id.toString())
            _tarea_seleccionada.value = tarea
        }
    }
}




