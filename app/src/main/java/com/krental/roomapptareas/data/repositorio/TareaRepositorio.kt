package com.krental.roomapptareas.data.repositorio

import com.krental.roomapptareas.data.local.dao.TareaDao
import com.krental.roomapptareas.data.local.entity.TareaEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TareaRepositorio @Inject constructor(
    private val tareaDao: TareaDao
) {
    suspend fun insertarTarea(tarea: TareaEntity) {
        tareaDao.insertarTarea(tarea)
    }

    fun obtenerTodasLasTareas(): Flow<List<TareaEntity>> {
        return tareaDao.obtenerTodasLasTareas()
    }

    suspend fun actualizarTarea(tarea: TareaEntity) {
        tareaDao.actualizarTarea(tarea)
    }

    suspend fun eliminarTarea(tarea: TareaEntity) {
        tareaDao.eliminarTarea(tarea)
    }

    suspend fun eliminarTodasLasTareas() {
        tareaDao.eliminarTodasLasTareas()
    }
}