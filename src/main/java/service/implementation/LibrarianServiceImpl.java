package service.implementation;

import model.Book;
import model.Person;
import service.LibrarianService;
import service.PersonTypeComparator;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class LibrarianServiceImpl implements LibrarianService {
    private final ArrayList<Book> books;
    private final PriorityQueue<Person> usersPriorityQueue ;

    public LibrarianServiceImpl() {
        books = new ArrayList<>();
        usersPriorityQueue = new PriorityQueue<>(new PersonTypeComparator());
    }


    @Override
    public void addBookToLibrarian(Book book) {
        books.add(book);
    }



//    @Override
//    public ArrayList<Book> getBooksFromLibrarian() {
//        return books;
//
//    }

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

    @Override
    public void assignEngine(Person person) {
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
    public void issueBook() {

        while (!usersPriorityQueue.isEmpty()) {
            Person person = usersPriorityQueue.poll();
            assignEngine(person);
        }
    }

    @Override
    public void priorityRequestPool(Person person) {
        if(person.personType != null){
            usersPriorityQueue.add(person);
            Person person1 = usersPriorityQueue.peek();
            if(!usersPriorityQueue.isEmpty() && !person1.book.equals(person.book)){
                assignEngine(person);
                usersPriorityQueue.remove(person);
            }

        }else{
            System.out.println("Cannot hard an invalid user to priority request pool: "+person);
        }
    }
}
