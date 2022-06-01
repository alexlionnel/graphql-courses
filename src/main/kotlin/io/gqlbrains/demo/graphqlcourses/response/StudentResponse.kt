package io.gqlbrains.demo.graphqlcourses.response

import io.gqlbrains.demo.graphqlcourses.entity.Student

data class StudentResponse(
    val id: Long,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val street: String?,
    val city: String?,
    val learningSubjects: List<SubjectResponse>?,
    // for internal, do not put in schema
    val student: Student,
    val fullName: String?
    ) {
    constructor(student: Student) : this(
        student.id!!,
        student.firstName,
        student.lastName,
        student.email,
        student.address?.street,
        student.address?.city,
        null,
        student,
        null
    )
}