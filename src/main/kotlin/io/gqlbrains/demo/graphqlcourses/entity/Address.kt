package io.gqlbrains.demo.graphqlcourses.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("address")
class Address (
    @Id
    var id: Long? = null,
    val street: String? = null,
    val city: String? = null,
    val student: Student? = null
)
