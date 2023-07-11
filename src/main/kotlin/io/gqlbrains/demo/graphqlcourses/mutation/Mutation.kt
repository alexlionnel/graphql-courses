package io.gqlbrains.demo.graphqlcourses.mutation

import graphql.kickstart.tools.GraphQLMutationResolver
import io.gqlbrains.demo.graphqlcourses.request.CreateStudentRequest
import io.gqlbrains.demo.graphqlcourses.response.StudentResponse
import io.gqlbrains.demo.graphqlcourses.service.StudentService
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class Mutation(private val studentService: StudentService): GraphQLMutationResolver {

    fun createStudent(createStudentRequest: CreateStudentRequest): Mono<StudentResponse> {
        return studentService.createStudent(createStudentRequest)
            .map { StudentResponse(it) }
    }
}