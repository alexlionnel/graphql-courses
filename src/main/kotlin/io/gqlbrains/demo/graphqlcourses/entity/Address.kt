package io.gqlbrains.demo.graphqlcourses.entity

import javax.persistence.*


@Entity
@Table(name = "address")
class Address (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    @Column(name = "street")
    val street: String? = null,

    @Column(name = "city")
    val city: String? = null,

    @OneToOne(mappedBy = "address")
    val student: Student? = null
)
