package io.gqlbrains.demo.graphqlcourses.response

import io.gqlbrains.demo.graphqlcourses.entity.Subject

data class SubjectResponse(val id: Long, val subjectName: String?, val marksObtained: Double?) {
    constructor(subject: Subject): this(subject.id!!, subject.subjectName, subject.marksObtained)
}