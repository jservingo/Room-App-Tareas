package com.krental.roomapptareas.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun obtenerFechaActal() : String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatter.format(Date())
}
