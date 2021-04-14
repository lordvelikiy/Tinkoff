package com.example.Tinkoff.data

import com.example.Tinkoff.dao.Student

object StudentData {
    fun getListStudent() = listOf(
            Student("1", "vasa", "Pupkin", "1"),
            Student("2", "Igor", "Bokov", "1"),
            Student("3", "Sveta", "Nee", "2"),
            Student("4", "Grisha", "Orlov", "2"),
            Student("5", "Lina", "Thaharova", "3"))
}

