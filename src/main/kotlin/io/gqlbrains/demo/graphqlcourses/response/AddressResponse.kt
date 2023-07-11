package io.gqlbrains.demo.graphqlcourses.response

import io.gqlbrains.demo.graphqlcourses.entity.Address

data class AddressResponse(val street: String, val city: String) {
    constructor(address: Address): this(
        address.street!!,
        address.city!!
    )
}
