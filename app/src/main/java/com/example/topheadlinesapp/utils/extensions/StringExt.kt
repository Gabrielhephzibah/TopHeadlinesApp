package com.example.topheadlinesapp.utils.extensions

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

fun String.formatDate(): String{
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'", Locale.ENGLISH)
    val outputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH)
    val localDate = LocalDate.parse(this, formatter)
    return outputFormat.format(localDate)
}

