package io.gqlbrains.demo.graphqlcourses.entity

import io.gqlbrains.demo.graphqlcourses.request.CreateStudentRequest
import javax.persistence.*


@Entity
@Table(name = "student")
class Student (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "first_name")
    val firstName: String? = null,

    @Column(name = "last_name")
    val lastName: String? = null,

    @Column(name = "email")
    val email: String? = null,

    @OneToOne
    @JoinColumn(name = "address_id")
    var address: Address? = null,

    @OneToMany(mappedBy = "student")
    var learningSubjects: List<Subject>? = null
) {

    constructor(createStudentRequest: CreateStudentRequest): this(
        firstName = createStudentRequest.firstName,
        lastName = createStudentRequest.lastName,
        email = createStudentRequest.email
    )
}
