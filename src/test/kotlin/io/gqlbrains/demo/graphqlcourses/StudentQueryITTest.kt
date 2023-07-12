package io.gqlbrains.demo.graphqlcourses

import com.graphql.spring.boot.test.GraphQLTest
import com.graphql.spring.boot.test.GraphQLTestTemplate
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.r2dbc.AutoConfigureDataR2dbc
import org.springframework.context.annotation.Import

@GraphQLTest
@Import(GraphqlCoursesApplication::class)
@AutoConfigureDataR2dbc
class StudentQueryITTest {

    @Autowired
    private lateinit var graphQLTestTemplate: GraphQLTestTemplate

    @Test
    @DisplayName("Application context should load correctly")
    fun testContextLoads() {
    }
}