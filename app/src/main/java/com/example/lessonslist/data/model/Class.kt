package com.example.lessonslist.data.model

data class Class(val name: String,
                 val startHour: Int,
                 val startMinute: Int,
                 val endHour: Int,
                 val endMinute: Int,
                 val icon: Int,
                 val teacher: String = "",
                 val text: String = "",
                 val isFaculty: Boolean = false)