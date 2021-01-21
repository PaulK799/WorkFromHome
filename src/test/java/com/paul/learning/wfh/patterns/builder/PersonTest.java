package com.paul.learning.wfh.patterns.builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * A test for the {@link Person} class.
 */
@SpringBootTest
public class PersonTest {

    /**
     * A test to validate the construction of a {@link Person} using the builder Pattern.
     */
    @Test
    public void buildPersonTest() {
        Person person = new Person
                .PersonBuilder()
                .withAge(30)
                .withFirstName("Bob")
                .withSurName("Dylan")
                .build();

        Assertions.assertEquals(30, person.getAge());
        Assertions.assertEquals("Bob", person.getFirstName());
        Assertions.assertEquals("Dylan", person.getSurName());
    }

    /**
     * A test to validate the construction of a {@link Person} using the builder Pattern.
     */
    @Test
    public void buildPersonEqualsTest() {
        Person personOne = new Person
                .PersonBuilder()
                .withAge(30)
                .withFirstName("Bob")
                .withSurName("Dylan")
                .build();

        Person personTwo = new Person
                .PersonBuilder()
                .withAge(30)
                .withFirstName("Bob")
                .withSurName("Dylan")
                .build();
        Assertions.assertEquals(personOne, personTwo);
        Assertions.assertEquals(personOne.hashCode(), personTwo.hashCode());
    }
}
