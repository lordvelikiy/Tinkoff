package com.example.Tinkoff.api

import com.example.Tinkoff.dao.Faculty
import com.example.Tinkoff.data.FacultyData
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/faculty")
class FacultyController {

    @GetMapping("/{id}")
    @ApiOperation("Получения сущности по id,параметры id, возвращаемое значение Faculty")
    fun getStudent(@PathVariable id: String): Faculty {

        val faculty = FacultyData.getListFaculty().find { it.id == id }

        return faculty!!
    }

    @GetMapping
    @ApiOperation("Получения сущности по id, возвращаемое значение List<Faculty>")
    fun getStudents(): List<Faculty> {
        return FacultyData.getListFaculty()
    }
}

