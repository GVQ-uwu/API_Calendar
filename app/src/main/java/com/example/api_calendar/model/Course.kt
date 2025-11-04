package com.example.api_calendar.model

data class Course(
    val name: String,
    val time: String,
    val teacher: String,
    val credits: Int,
    val room: String
)