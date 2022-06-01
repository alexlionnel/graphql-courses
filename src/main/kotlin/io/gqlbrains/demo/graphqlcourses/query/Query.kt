package io.gqlbrains.demo.graphqlcourses.query

import graphql.kickstart.tools.GraphQLQueryResolver
import io.gqlbrains.demo.graphqlcourses.request.SampleRequest
import io.gqlbrains.demo.graphqlcourses.response.StudentResponse
import io.gqlbrains.demo.graphqlcourses.service.StudentService
import org.springframework.stereotype.Component

// Cette classe est une sorte de controlleur pour gérer les requêtes query
// toutes les requêtes sont http post
@Component
class Query(private val studentService: StudentService): GraphQLQueryResolver {

    fun firstQuery(): String {
        return "First query"
    }

    fun secondQuery(): String {
        return "Second query"
    }

    fun fullName(firstName: String?, lastName: String?): String {
        return "$firstName $lastName";
    }

    fun fullNameSampleRequest(sampleRequest: SampleRequest): String {
        return sampleRequest.firstName + " " + sampleRequest.lastName
    }

    fun getStudent(id: Long): StudentResponse {
        return StudentResponse(studentService.getStudentById(id))
    }
}