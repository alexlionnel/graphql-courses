package io.gqlbrains.demo.graphqlcourses

import com.fasterxml.jackson.databind.ObjectMapper
import com.graphql.spring.boot.test.GraphQLTest
import com.graphql.spring.boot.test.GraphQLTestTemplate
import io.gqlbrains.demo.graphqlcourses.request.CreateStudentRequest
import io.gqlbrains.demo.graphqlcourses.request.CreateSubjectRequest
import org.assertj.core.api.Assertions.assertThat
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
        val variables = ObjectMapper().createObjectNode()
        variables.putPOJO("", CreateStudentRequest(
            firstName = "alex",
            lastName = "albrains",
            email = "albrains@yahoo.com",
            street = "rue de la joie",
            city = "yaounde",
            subjectsLearning = listOf(
                CreateSubjectRequest(subjectName = "java", marksObtained = 7.2)
            )
        ))

        val response = graphQLTestTemplate.perform("graphql/create-student.graphql", variables)
        assertThat(response).isNotNull()
        assertThat(response.get("$.data.createPost.id")).isNotNull();
    }
}