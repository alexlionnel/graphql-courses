package io.gqlbrains.demo.graphqlcourses.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("subject")
class Subject(
    @Id
    var id: Long? = null,
    val subjectName: String? = null,
    val marksObtained: Double? = null,
    val studentId: Long? = null
)
