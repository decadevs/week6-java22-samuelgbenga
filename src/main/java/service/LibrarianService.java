package service;

import model.Book;
import model.Person;

public interface LibrarianService {

    public void addBookToLibrarian(Book book);
    public void assignEngine(Person person);
    public void issueBook();
    public void priorityRequestPool(Person person);


}
