package io.glbrains.demo.graphqlcourses;

import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import io.gqlbrains.demo.graphqlcourses.GraphqlCoursesApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.context.annotation.Import;

@GraphQLTest
@Import(GraphqlCoursesApplication.class)
@AutoConfigureDataJpa
public class GraphqlITTest {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;
    @Test
    void loadContext() {

    }
}
