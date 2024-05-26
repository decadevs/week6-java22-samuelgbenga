package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testToString() {
        Book book = new Book("title", "author", "123");
        assertEquals("[title, author, 123]", book.toString());
    }
}