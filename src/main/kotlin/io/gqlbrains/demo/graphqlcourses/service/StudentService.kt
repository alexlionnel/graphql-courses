package io.gqlbrains.demo.graphqlcourses.service

import io.gqlbrains.demo.graphqlcourses.entity.Address
import io.gqlbrains.demo.graphqlcourses.entity.Student
import io.gqlbrains.demo.graphqlcourses.entity.Subject
import io.gqlbrains.demo.graphqlcourses.repository.AddressRepository
import io.gqlbrains.demo.graphqlcourses.repository.StudentRepository
import io.gqlbrains.demo.graphqlcourses.repository.SubjectRepository
import io.gqlbrains.demo.graphqlcourses.request.CreateStudentRequest
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono


@Service
class StudentService(private val studentRepository: StudentRepository,
                     private val addressRepository: AddressRepository,
                     private val subjectRepository: SubjectRepository) {

    fun getStudentById(id: Long): Mono<Student?> {
        return studentRepository.findById(id)
    }

    fun createStudent(createStudentRequest: CreateStudentRequest): Mono<Student> {
        val address = Address(street = createStudentRequest.street, city = createStudentRequest.city)
        return addressRepository.save(address)
            .flatMap {
                val student = Student(createStudentRequest)
                student.addressId = it.id
                studentRepository.save(student)
            }
            .flatMap {student ->
                val subjectsList = createStudentRequest.subjectsLearning?.let {
                    it.map{createSubjectRequest -> Subject(
                        subjectName = createSubjectRequest.subjectName,
                        marksObtained = createSubjectRequest.marksObtained,
                        studentId = student.id
                    )}
                }?: listOf()
                subjectRepository.saveAll(subjectsList)
                    .collectList()
                    //.doOnNext{list -> student.learningSubjects = list}
                    .thenReturn(student)
            }
    }
}