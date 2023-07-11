package io.gqlbrains.demo.graphqlcourses.repository

import io.gqlbrains.demo.graphqlcourses.entity.Student
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface StudentRepository: ReactiveCrudRepository<Student, Long>