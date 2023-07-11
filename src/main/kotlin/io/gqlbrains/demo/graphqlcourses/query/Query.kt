package io.gqlbrains.demo.graphqlcourses.query

import graphql.kickstart.tools.GraphQLQueryResolver
import io.gqlbrains.demo.graphqlcourses.request.SampleRequest
import io.gqlbrains.demo.graphqlcourses.response.StudentResponse
import io.gqlbrains.demo.graphqlcourses.service.StudentService
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import java.lang.RuntimeException
import java.time.Duration

// Cette classe est une sorte de controlleur pour gérer les requêtes query
// toutes les requêtes sont http post
@Component
class Query(private val studentService: StudentService): GraphQLQueryResolver {

    fun firstQuery(): Mono<String> {
        return Mono.just("First query")
    }

    fun secondQuery(): Mono<String> {
        return Mono.just("Second query")
    }

    fun fullName(firstName: String?, lastName: String?): Mono<String> {
        return Mono.just("$firstName $lastName")
    }

    fun fullNameSampleRequest(sampleRequest: SampleRequest): Mono<String> {
        return Mono.just(sampleRequest.firstName + " " + sampleRequest.lastName)
    }

    fun getStudent(id: Long): Mono<StudentResponse> {
        return studentService.getStudentById(id)
            .mapNotNull { student-> student?.let { StudentResponse(it) } }
            .switchIfEmpty(Mono.error(RuntimeException("cannot find user with id $id")))
    }
}