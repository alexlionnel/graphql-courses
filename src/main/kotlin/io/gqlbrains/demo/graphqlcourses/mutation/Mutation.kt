package io.gqlbrains.demo.graphqlcourses.mutation

import graphql.kickstart.tools.GraphQLMutationResolver
import io.gqlbrains.demo.graphqlcourses.request.CreateStudentRequest
import io.gqlbrains.demo.graphqlcourses.response.StudentResponse
import io.gqlbrains.demo.graphqlcourses.service.StudentService
import org.springframework.stereotype.Service

@Service
class Mutation(private val studentService: StudentService): GraphQLMutationResolver {

    fun createStudent(createStudentRequest: CreateStudentRequest): StudentResponse {
        return StudentResponse(studentService.createStudent(createStudentRequest))
    }
}