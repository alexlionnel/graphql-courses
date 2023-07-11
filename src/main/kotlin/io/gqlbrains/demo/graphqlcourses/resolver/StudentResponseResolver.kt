package io.gqlbrains.demo.graphqlcourses.resolver

import graphql.kickstart.tools.GraphQLResolver
import io.gqlbrains.demo.graphqlcourses.enums.SubjectNameFilter
import io.gqlbrains.demo.graphqlcourses.repository.AddressRepository
import io.gqlbrains.demo.graphqlcourses.repository.SubjectRepository
import io.gqlbrains.demo.graphqlcourses.response.AddressResponse
import io.gqlbrains.demo.graphqlcourses.response.StudentResponse
import io.gqlbrains.demo.graphqlcourses.response.SubjectResponse
import org.reactivestreams.Publisher
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class StudentResponseResolver(
    private val subjectRepository: SubjectRepository,
    private val addressRepository: AddressRepository
): GraphQLResolver<StudentResponse> {

    fun getLearningSubjects(studentResponse: StudentResponse, subjectNameFilter: SubjectNameFilter): Mono<List<SubjectResponse>> {
        return subjectRepository.findByStudentIdAndSubjectNameIn(studentResponse.id, listOf(SubjectNameFilter.All.name, subjectNameFilter.name))
            .map { subject -> SubjectResponse(subject) }
            .collectList()
            .switchIfEmpty(Mono.just(emptyList()))
        /*return Mono.fromSupplier {
            studentResponse.student.learningSubjects?.let {
                it.filter {
                        subject -> subjectNameFilter == SubjectNameFilter.All || subject.subjectName.equals(subjectNameFilter.name)
                }.map { subject -> SubjectResponse(subject) }
            } ?: emptyList()
        }*/
    }

    fun getAddress(studentResponse: StudentResponse): Mono<AddressResponse?> {
        return studentResponse.addressId?. let {
            addressRepository.findById(it)
                .map {address -> AddressResponse(address) }
        } ?: Mono.empty()
    }

    fun getFullName(studentResponse: StudentResponse): Mono<String> {
        return Mono.just(studentResponse.firstName + " " + studentResponse.lastName)
    }
}