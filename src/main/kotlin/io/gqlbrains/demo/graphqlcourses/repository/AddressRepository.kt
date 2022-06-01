package io.gqlbrains.demo.graphqlcourses.repository

import io.gqlbrains.demo.graphqlcourses.entity.Address
import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepository: JpaRepository<Address, Long>