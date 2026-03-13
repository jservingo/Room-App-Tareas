package com.krental.roomapptareas.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.krental.roomapptareas.data.local.entity.TareaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TareaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarTarea(tarea: TareaEntity)

    @Query("SELECT * FROM tareas ORDER BY id DESC")
    //Esto expone un Flow desde el DAO
    fun obtenerTodasLasTareas(): Flow<List<TareaEntity>>

    @Update
    suspend fun actualizarTarea(tarea: TareaEntity)

    @Delete
    suspend fun eliminarTarea(tarea: TareaEntity)

    @Query("DELETE from tareas")
    suspend fun eliminarTodasLasTareas()
}