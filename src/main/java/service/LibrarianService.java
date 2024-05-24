package service;

import model.Book;
import model.Person;

import java.util.ArrayList;

public interface LibrarianService {

    public void addBookToLibrarian(Book book);
    public void issueBookBasedOnPriority();
    public void priorityRequestPool(Person person);
    //public ArrayList<Book> getBooksFromLibrarian();
    public void issueBook(Person person);
}
