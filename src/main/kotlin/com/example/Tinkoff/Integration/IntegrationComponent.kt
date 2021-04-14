package com.example.Tinkoff.Integration

import com.example.Tinkoff.dao.Faculty
import com.example.Tinkoff.dao.Student
import com.example.Tinkoff.dao.StudentFaculty
import org.springframework.web.client.RestTemplate


class FacultyIntegrationComponent {
    private val restTemplate: RestTemplate = RestTemplate()


    fun getFac(): List<Faculty> {
        val faculty = restTemplate.getForObject("http://localhost:8080/faculty", Array<Faculty>::class.java)

        return faculty?.asList() ?: emptyList()
    }
}

fun createStudentFaculty(student:Student): StudentFaculty? {
    FacultyIntegrationComponent().getFac().forEach {
        if (student.idFaculty == it.id)
            return StudentFaculty(student.id, student.firstName, student.lastName, it.faculty, it.deanLastName)
    }

    return StudentFaculty(student.id, student.firstName, student.lastName, "it.faculty", "it.deanLastName")
}