package com.example.lessonslist.data

import com.example.lessonslist.data.model.Class
import com.example.lessonslist.data.model.Homework

interface IRepository {
    fun getClasses(): List<Class>
    fun getCurrentClassIndex(): Int
    fun getHomeworks(): List<Homework>
}