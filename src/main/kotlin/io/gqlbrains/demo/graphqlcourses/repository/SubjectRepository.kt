package io.gqlbrains.demo.graphqlcourses.repository

import io.gqlbrains.demo.graphqlcourses.entity.Subject
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface SubjectRepository: ReactiveCrudRepository<Subject, Long> {
    fun findByStudentIdAndSubjectNameIn(studentId: Long, names: List<String>): Flux<Subject>
}