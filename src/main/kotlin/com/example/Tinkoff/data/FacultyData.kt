package com.example.Tinkoff.data

import com.example.Tinkoff.dao.Faculty

object FacultyData {
    fun getListFaculty() = listOf(
            Faculty("1","Radio Engineering","Kalinin"),
            Faculty("2","Geographical","Grachev"),
            Faculty("3","Economically","Sobolev"),
            Faculty("4","Journalism","Posner")
    )
}