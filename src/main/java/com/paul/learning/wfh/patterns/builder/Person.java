package com.paul.learning.wfh.patterns.builder;

import java.util.Objects;

/**
 * A class representing a {@link Person} written using the Builder Design Pattern.
 */
public final class Person {
    private int age;
    private String firstName;
    private String surName;

    /**
     * Private constructor to hide from instantiation.
     */
    private Person() {
        // Do nothing.
    }

    /**
     * A builder class for {@link Person}.
     */
    public static class PersonBuilder {
        private int age;
        private String firstName;
        private String surName;

        /**
         * Adds age to the {@link PersonBuilder}.
         *
         * @param age - The age of the {@link PersonBuilder} being processed.
         * @return The {@link PersonBuilder}.
         */
        public PersonBuilder withAge(int age) {
            this.age = age;
            return this;
        }

        /**
         * Adds an firstName to the {@link PersonBuilder}.
         *
         * @param firstName - The firstName of the {@link PersonBuilder} being processed.
         * @return The {@link PersonBuilder}.
         */
        public PersonBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        /**
         * Adds an surName to the {@link PersonBuilder}.
         *
         * @param surName - The surName of the {@link PersonBuilder} being processed.
         * @return The {@link PersonBuilder}.
         */
        public PersonBuilder withSurName(String surName) {
            this.surName = surName;
            return this;
        }

        /**
         * Build a {@link Person} using {@link PersonBuilder}.
         *
         * @return The {@link Person}.
         */
        public Person build() {
            Person person = new Person();
            person.age = this.age;
            person.firstName = this.firstName;
            person.surName = this.surName;
            return person;
        }
    }

    /**
     * Gets the age of the {@link Person}.
     *
     * @return The age of the {@link Person}.
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the firstName of the {@link Person}.
     *
     * @return The firstName of the {@link Person}.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the surName of the {@link Person}.
     *
     * @return The surName of the {@link Person}.
     */
    public String getSurName() {
        return surName;
    }

    /**
     * Implements object comparison
     *
     * @param obj - The {@link Object} being parsed.
     * @return A boolean indicating if equals to {@link Person}.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person that = (Person) obj;
        return Objects.equals(this.age, that.age) &&
                Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.surName, that.surName);
    }

    /**
     * Returns the hashCode for the {@link Person}.
     *
     * @return The hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(age, firstName, surName);
    }
}
