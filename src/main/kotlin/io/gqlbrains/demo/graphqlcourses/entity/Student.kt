package io.gqlbrains.demo.graphqlcourses.entity

import io.gqlbrains.demo.graphqlcourses.request.CreateStudentRequest
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.relational.core.mapping.Table

@Table("student")
class Student (
    @Id
    var id: Long? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val email: String? = null,
    var addressId: Long? = null,
) {

    constructor(createStudentRequest: CreateStudentRequest): this(
        firstName = createStudentRequest.firstName,
        lastName = createStudentRequest.lastName,
        email = createStudentRequest.email
    )
}
