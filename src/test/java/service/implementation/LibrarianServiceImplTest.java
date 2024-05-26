package service.implementation;

import model.Book;
import model.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.PersonTypeComparator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianServiceImplTest {

    // handle printed on console
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    // the after and before for console display
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    @AfterEach
    public void restoreStream(){
        System.setOut(originalOut);
    }

    LibrarianServiceImpl librarianService = new LibrarianServiceImpl();
    @Test
    void addBookToLibrarian() throws Exception{
        Book book = new Book("title", "author", "1234");
        librarianService.addBookToLibrarian(book);
        Field field = librarianService.getClass().getDeclaredField("books");
        field.setAccessible(true);
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        assertEquals(books, field.get(librarianService));

    }

    @Test
    void assignBook() throws Exception {

        Person person = new Person("John", "jnr12e");
        Person person1 = new Person("John1", "snr134");
        Book book = new Book("title", "author", "1234");
        Book book2 = new Book("title2", "author2", "1234");
        librarianService.addBookToLibrarian(book);
        librarianService.addBookToLibrarian(book2);
        person.requestBook(book);
        person1.requestBook(book2);
        librarianService.priorityRequestPool(person);
        librarianService.priorityRequestPool(person1);

        Method method = librarianService.getClass().getDeclaredMethod("isToPrioritize");
        method.setAccessible(true);

        assertEquals(false,  method.invoke(librarianService));

    }




    @Test
    void testAssignBookThatHandlesAllBooksAssignment() {

        Person person = new Person("name", "jnr123");
        Book book = new Book("title", "author", "1234");
        librarianService.addBookToLibrarian(book);
        person.requestBook(book);
        librarianService.assignBook(person);
        assertEquals(person + " has been issued " + person.book+"\n", outContent.toString());
    }

    @Test
    void testAssignBookThatHandlesAllBooksNotAssignment() {

        Person person = new Person("name", "jnr123");
        Book book = new Book("title", "author", "1234");
        Book book1 = new Book("title1", "author1", "12341");
        librarianService.addBookToLibrarian(book1);
        person.requestBook(book);
        librarianService.assignBook(person);
        assertEquals(person + " cannot be issued " + person.book + " due to unavailability."+"\n", outContent.toString());
    }

    @Test
    void priorityRequestPoolForNullOrInvalidUser() {
        Person person = new Person("name", "jn123");

        librarianService.priorityRequestPool(person);

       assertEquals("Invalid Library User: "+person+"\n", outContent.toString());

    }

    @Test
    void priorityRequestPoolTestForValidUsersAddedToQueue() throws Exception{
        Person person = new Person("name", "jnr123");

        librarianService.priorityRequestPool(person);

        Field field = librarianService.getClass().getDeclaredField("usersPriorityQueue");
        field.setAccessible(true);
        PriorityQueue<Person> priorityQueue = new PriorityQueue<>(new PersonTypeComparator());
        priorityQueue.add(person);

        assertEquals(priorityQueue.toString(), field.get(librarianService).toString());

    }
}