package com.example.Tinkoff.api

import com.example.Tinkoff.Integration.createStudentFaculty
import com.example.Tinkoff.dao.Student
import com.example.Tinkoff.dao.StudentFaculty
import com.example.Tinkoff.data.StudentData
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/student")
class StudentController {

    @GetMapping
    @ApiOperation("Получения всех сущностей,возвращаемое значение List<StudentFaculty>")
    fun getStudents(): List<StudentFaculty> {
        val list = mutableListOf<StudentFaculty>()
       StudentData.getListStudent().forEach { list.add(createStudentFaculty(it)!!)  }
        return list
    }
    @PostMapping
    @ApiOperation("Добавления сущности ")
    fun addStudent(@RequestBody student: Student) {
        println("Был добавлен студент = $student")
    }

    @PutMapping("/{id}")
    @ApiOperation("Обновления сущности, параметры id")
    fun updateStudent(@PathVariable id: String, @RequestBody student: Student) {
        println("Студент был обновлен. Студент = $student, id = $id")
    }

    @DeleteMapping("/{id}")
    @ApiOperation("удаления сущности, параметры id")
    fun deleteStudent(@PathVariable id: String) {
        println("Студент удален с id = $id")
    }

    @GetMapping("/{id}")   //
    @ApiOperation("получения сущности по id, возвращаемое значение StudentFaculty ")
    fun getStudent(@PathVariable id: String): StudentFaculty? {
        val student = StudentData.getListStudent().find { it.id == id }
        return createStudentFaculty(student!!)
    }
}
