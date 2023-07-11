package io.gqlbrains.demo.graphqlcourses.repository

import io.gqlbrains.demo.graphqlcourses.entity.Address
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface AddressRepository: ReactiveCrudRepository<Address, Long>