package service;

import enums.PersonType;
import model.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class PersonTypeComparatorTest {
    PersonTypeComparator personTypeComparator = new PersonTypeComparator();

    @Test
    void compareTeachVsSnr(){
        Person tch = new Person("name", "tch123");
        Person snr = new Person("name1", "snr123");

        int result = personTypeComparator.compare(tch, snr);
        assertEquals(-1, result);
    }


    @Test
    void compareSnrVsTeacher(){
        Person tch = new Person("name", "tch123");
        Person snr = new Person("name1", "snr123");

        int result = personTypeComparator.compare(snr, tch);
        assertEquals(1, result);
    }

    @Test
    void compareTeachVsJnr(){
        Person tch = new Person("name", "tch123");
        Person jnr = new Person("name1", "jnr123");
        int result = personTypeComparator.compare(tch, jnr);
        assertEquals(-1, result);
    }

    @Test
    void compareJnrVsTeacher(){
        Person tch = new Person("name", "tch123");
        Person jnr = new Person("name1", "jnr123");
        int result = personTypeComparator.compare(jnr, tch);
        assertEquals(1, result);
    }

    @Test
    void compareSnrVsJnr(){
        Person snr = new Person("name", "snr123");
        Person jnr = new Person("name1", "jnr123");
        int result = personTypeComparator.compare(snr, jnr);
        assertEquals(-1, result);
    }

    @Test
    void compareJnrVsSnr(){
        Person snr = new Person("name", "snr123");
        Person jnr = new Person("name1", "jnr123");
        int result = personTypeComparator.compare(jnr,snr);
        assertEquals(1, result);
    }

}