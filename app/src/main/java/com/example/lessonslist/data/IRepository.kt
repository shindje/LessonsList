package com.example.lessonslist.data

import com.example.lessonslist.data.model.Class

interface IRepository {
    fun getClasses(): List<Class>
    fun getCurrentClassIndex(): Int
}