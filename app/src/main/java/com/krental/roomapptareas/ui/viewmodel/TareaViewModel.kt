package com.krental.roomapptareas.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krental.roomapptareas.data.local.entity.TareaEntity
import com.krental.roomapptareas.data.repositorio.TareaRepositorio
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TareaViewModel @Inject constructor(
    private val tareaRepositorio: TareaRepositorio
) : ViewModel() {
    private val _tareas = MutableStateFlow<List<TareaEntity>>(emptyList())
    val tareas: StateFlow<List<TareaEntity>> = _tareas

    init {
        viewModelScope.launch {
            tareaRepositorio.obtenerTodasLasTareas().collect {
                _tareas.value = it
            }
        }
    }
}




