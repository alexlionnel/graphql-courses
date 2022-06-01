package io.gqlbrains.demo.graphqlcourses.repository

import io.gqlbrains.demo.graphqlcourses.entity.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository: JpaRepository<Student, Long>