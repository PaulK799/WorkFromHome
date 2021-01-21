package com.paul.learning.wfh.patterns.builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * A test for the {@link Person} class.
 */
@SpringBootTest
public class PersonTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonTest.class);

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
        LOGGER.info(person.toString());
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
        LOGGER.info("Person 1: {}", personOne.toString());
        LOGGER.info("Person 2: {}", personTwo.toString());
        Assertions.assertEquals(personOne, personTwo);
        Assertions.assertEquals(personOne.hashCode(), personTwo.hashCode());
    }

    /**
     * A test to validate the construction of a {@link Person} using the builder Pattern.
     */
    @Test
    public void buildPersonEqualsFailureTest() {
        Person personOne = new Person
                .PersonBuilder()
                .withAge(30)
                .withFirstName("Bob")
                .withSurName("Dylan")
                .build();

        Person personTwo = new Person
                .PersonBuilder()
                .withAge(30)
                .withFirstName("Bobb")
                .withSurName("Dylan")
                .build();
        LOGGER.info("Person 1: {}", personOne.toString());
        LOGGER.info("Person 2: {}", personTwo.toString());
        Assertions.assertNotEquals(personOne, personTwo);
        Assertions.assertNotEquals(personOne.hashCode(), personTwo.hashCode());
    }
}
