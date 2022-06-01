package io.gqlbrains.demo.graphqlcourses.service

import io.gqlbrains.demo.graphqlcourses.entity.Address
import io.gqlbrains.demo.graphqlcourses.entity.Student
import io.gqlbrains.demo.graphqlcourses.entity.Subject
import io.gqlbrains.demo.graphqlcourses.repository.AddressRepository
import io.gqlbrains.demo.graphqlcourses.repository.StudentRepository
import io.gqlbrains.demo.graphqlcourses.repository.SubjectRepository
import io.gqlbrains.demo.graphqlcourses.request.CreateStudentRequest
import org.springframework.stereotype.Service


@Service
class StudentService(private val studentRepository: StudentRepository,
                     private val addressRepository: AddressRepository,
                     private val subjectRepository: SubjectRepository) {

    fun getStudentById(id: Long): Student {
        return studentRepository.getById(id)
    }

    fun createStudent(createStudentRequest: CreateStudentRequest): Student {
        var student = Student(createStudentRequest)
        var address = Address(street = createStudentRequest.street, city = createStudentRequest.city)
        address = addressRepository.save(address)
        student.address = address
        student = studentRepository.save(student)
        val subjectsList = createStudentRequest.subjectsLearning?.let {
            it.map{createSubjectRequest -> Subject(
                subjectName = createSubjectRequest.subjectName,
                marksObtained = createSubjectRequest.marksObtained,
                student = student
            )}
        }?: listOf()
        subjectRepository.saveAll(subjectsList)
        student.learningSubjects = subjectsList
        return student
    }
}