package model;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void getFullName() {
        Person person = new Person("John", "jnr");
        assertEquals("John", person.getFullName());
    }

    @Test
    void getPersonId() {
        Person person = new Person("John", "jnr");
        assertEquals("jnr", person.getPersonId());
    }

    @Test
    void requestBook() throws Exception {
        Person person = new Person("John", "jnr");
        Book book1 = new Book("title", "author", "123");
        person.requestBook(book1);
        Field field = person.getClass().getField("book");

        assertEquals("[title, author, 123]", field.get(person).toString());

    }

    @Test
    void testToString() {

        Person person = new Person("John", "jnr");
        assertEquals("[John, jnr]", person.toString());
    }
}