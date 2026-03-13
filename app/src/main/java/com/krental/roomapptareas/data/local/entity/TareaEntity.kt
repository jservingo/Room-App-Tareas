package com.krental.roomapptareas.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

//Esta clase representa una tabla
@Entity(tableName = "tareas")

//Este es el contructor primario de TareaEntity
//Sirve para generar automaticamente los codigos y para
//reconstruir objetos al leerlos desde la BD
//Tambien existe constructor secundario y sirven para
//ofrecer disferentes formas de inicializar la clase,
//agregar logica antes o despues de la contruccion
//de objetos y delegar la construccion hacia el
//constructor primario

data class TareaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var titulo: String,
    val descripcion: String ?= null,
    val completada: Boolean = false,
    val fechaCreacion: String
)

