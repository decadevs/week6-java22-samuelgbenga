package service.implementation;

import model.Book;
import model.Person;
import service.LibrarianService;
import service.PersonTypeComparator;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Optional;

public class LibrarianServiceImpl implements LibrarianService {
   // arraylist for books
    private final ArrayList<Book> books;

    // priority Queue to prioritize the users request which involves same book
    private final PriorityQueue<Person> usersPriorityQueue ;

    // the constructor: initializes the priorityQueue
    public LibrarianServiceImpl() {
        books = new ArrayList<>();
        usersPriorityQueue = new PriorityQueue<>(new PersonTypeComparator());
    }

    // check if the book is available on the shelf
    private boolean isBookAvailable(Book book) {
//        for(Book book1 : books) {
//            if(book1.equals(book)) {
//                return true;
//            }
//        }
// return false;
        return books.stream().anyMatch(x-> x.equals(book));
    }

    // remove book from the arrayList
    private void giveOutBook(Book book) {
        books.remove(book);
    }

    // check if the books is to be prioritize
    // if a book exist that is not same returns false
    private boolean isToPrioritize(){

        Person person = usersPriorityQueue.peek();

//        for (Person person1: usersPriorityQueue) {
//            if(!person.book.equals(person1.book)) {
//                return false;
//            }
//        }
        return usersPriorityQueue.stream().allMatch(x-> x.book.equals(person.book));
    }


    //adds book to the arrayList
    @Override
    public void addBookToLibrarian(Book book) {
        books.add(book);
    }

    @Override
    public void assignBook(Person person) {
//        if(person.personType != null){
//            if(isBookAvailable(person.book)){
//                System.out.println(person+" has been issued "+ person.book);
//                giveOutBook(person.book);
//
//            }else{
//                System.out.println(person+" cannot be issued "+ person.book +" due to unavailability.");
//            }
//
//        }else{
//            System.out.println("Invalid Library User");
//        }
        Optional.ofNullable(person.personType)
                .map(_ -> {
                    if (isBookAvailable(person.book)) {
                        giveOutBook(person.book);
                        return person + " has been issued " + person.book;
                    } else {
                        return person + " cannot be issued " + person.book + " due to unavailability.";
                    }
                })
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Invalid Library User: " + person)
                );
    }


    @Override
    public void assignBook() {
        if(!isToPrioritize()) {
            usersPriorityQueue.clear();
            System.out.println("Invalid Priority Queue");
            return;
        }
//        while (!usersPriorityQueue.isEmpty()) {
//            Person person = usersPriorityQueue.poll();
//            assignBook(person);
//        }
        // used forEach and clear the method afterwords used ::
        // using method reference without
        // which is to call a method without invoking them
        usersPriorityQueue.forEach(this::assignBook);
        usersPriorityQueue.clear();

    }

    @Override
    public void priorityRequestPool(Person person) {
//        if(person.personType != null){
//            usersPriorityQueue.add(person);
//        }else{
//            System.out.println("Cannot hard an invalid user to priority request pool: "+person);
//        }
        Optional.ofNullable(person.personType)
                .ifPresentOrElse(_->usersPriorityQueue.add(person),
                        () -> System.out.println("Invalid Library User: "+person));


    }
}
