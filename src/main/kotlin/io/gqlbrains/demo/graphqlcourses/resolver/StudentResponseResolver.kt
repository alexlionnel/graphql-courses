package io.gqlbrains.demo.graphqlcourses.resolver

import graphql.kickstart.tools.GraphQLResolver
import io.gqlbrains.demo.graphqlcourses.enums.SubjectNameFilter
import io.gqlbrains.demo.graphqlcourses.response.StudentResponse
import io.gqlbrains.demo.graphqlcourses.response.SubjectResponse
import org.springframework.stereotype.Service

@Service
class StudentResponseResolver: GraphQLResolver<StudentResponse> {

    fun getLearningSubjects(studentResponse: StudentResponse, subjectNameFilter: SubjectNameFilter): List<SubjectResponse> {
        return studentResponse.student.learningSubjects?.let {
            it.filter { subject -> subjectNameFilter == SubjectNameFilter.All || subject.subjectName.equals(subjectNameFilter.name) }
                .map { subject -> SubjectResponse(subject) }
        } ?: listOf()
    }

    fun getFullName(studentResponse: StudentResponse): String {
        return studentResponse.firstName + " " + studentResponse.lastName
    }
}