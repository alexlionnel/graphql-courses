package io.gqlbrains.demo.graphqlcourses.response

import io.gqlbrains.demo.graphqlcourses.entity.Student

data class StudentResponse(
    val id: Long,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val addressId: Long?,
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
        student.addressId,
        null,
        student,
        null
    )
}