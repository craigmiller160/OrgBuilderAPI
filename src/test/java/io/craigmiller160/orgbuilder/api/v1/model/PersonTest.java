package io.craigmiller160.orgbuilder.api.v1.model;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * JUnit test case for methods that
 * do more than just set/get values
 * in the Person model class.
 *
 * Created by Craig on 1/8/2016.
 */
public class PersonTest {

    @Test
    public void testAge(){
        Person person = new Person();
        person.setBirthDate(LocalDate.of(1988, 10, 26));

        assertEquals(27, person.getAge());
    }

}
