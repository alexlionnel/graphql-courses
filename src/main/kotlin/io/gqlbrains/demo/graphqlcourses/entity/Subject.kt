package io.gqlbrains.demo.graphqlcourses.entity

import javax.persistence.*

@Entity
@Table(name = "subject")
class Subject(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "subject_name")
    val subjectName: String? = null,

    @Column(name = "marks_obtained")
    val marksObtained: Double? = null,

    @ManyToOne
    @JoinColumn(name = "student_id")
    val student: Student? = null
)
