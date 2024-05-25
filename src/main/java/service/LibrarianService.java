package service;

import model.Book;
import model.Person;

public interface LibrarianService {

    public void addBookToLibrarian(Book book);
    public void assignBook(Person person);
    public void assignBook();
    public void priorityRequestPool(Person person);


}
