package service.implementation;

import model.Book;
import model.Person;
import org.w3c.dom.ls.LSOutput;
import service.LibrarianService;
import service.PersonTypeComparator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class LibrarianServiceImpl implements LibrarianService {
    private final ArrayList<Book> books;
    private final PriorityQueue<Person> usersPriorityQueue ;

    public LibrarianServiceImpl() {
        books = new ArrayList<>();
        usersPriorityQueue = new PriorityQueue<>(new PersonTypeComparator());
    }






    private boolean isBookAvailable(Book book) {

        for(Book book1 : books) {
            if(book1.equals(book)) {
                return true;
            }
        }

        return false;
    }

    private void giveOutBook(Book book) {
        books.remove(book);
    }

    private boolean isPrioritize(){

        Person person = usersPriorityQueue.peek();
        for (Person person1: usersPriorityQueue) {
            if(!person.book.equals(person1.book)) {
                return false;
            }
        }

        return true;
    }


    @Override
    public void addBookToLibrarian(Book book) {
        books.add(book);
    }


    @Override
    public void assignBook(Person person) {
        if(person.personType != null){
            if(isBookAvailable(person.book)){
                System.out.println(person+" has been issued "+ person.book);
                giveOutBook(person.book);

            }else{
                System.out.println(person+" cannot be "+ person.book +" due to unavailability.");
            }

        }else{
            System.out.println("Invalid Library User");
        }
    }


    @Override
    public void assignBook() {
        if(!isPrioritize()) {
            usersPriorityQueue.clear();
            System.out.println("Invalid Priority Queue");
            return;
        }
        while (!usersPriorityQueue.isEmpty()) {
            Person person = usersPriorityQueue.poll();
            assignBook(person);
        }
    }

    @Override
    public void priorityRequestPool(Person person) {
        if(person.personType != null){
            usersPriorityQueue.add(person);
        }else{
            System.out.println("Cannot hard an invalid user to priority request pool: "+person);
        }
    }
}
