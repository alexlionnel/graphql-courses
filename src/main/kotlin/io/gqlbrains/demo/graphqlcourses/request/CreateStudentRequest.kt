package io.gqlbrains.demo.graphqlcourses.request

data class CreateStudentRequest(
    val firstName: String,
    val lastName: String,
    val email: String,
    val street: String,
    val city: String,
    val subjectsLearning: List<CreateSubjectRequest>?
    )
