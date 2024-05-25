import model.Book;
import model.Person;
import service.LibrarianService;
import service.implementation.LibrarianServiceImpl;

public class SchoolLibrary {
    public static void main(String[] args) {

        // instantiate person
        Person person1 = new Person("Alice Smith", "snr120");
        Person person2 = new Person("Bob Johnson", "jnr124");
        Person person3 = new Person("Charlie Brown", "tch723");
        Person person4 = new Person("Diana Prince", "tch123");
        Person person5 = new Person("Evan Wright", "jnr129");
        Person person6 = new Person("Eva rig", "snr109");

        // instantiate books
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");
        Book book2 = new Book("1984", "George Orwell", "978-0451524935");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0060935467");
        Book book4 = new Book("Pride and Prejudice", "Jane Austen", "978-1503290563");
        Book book5 = new Book("Moby-Dick", "Herman Melville", "978-1503280786");




        //instantiate services
        LibrarianService librarianService = new LibrarianServiceImpl();




        // Add book to library
        librarianService.addBookToLibrarian(book1);
        librarianService.addBookToLibrarian(book1);
        librarianService.addBookToLibrarian(book1);
        librarianService.addBookToLibrarian(book2);
        librarianService.addBookToLibrarian(book3);
        librarianService.addBookToLibrarian(book4);
        librarianService.addBookToLibrarian(book5);



        //make request for book
        person1.requestBook(book1);
        person2.requestBook(book3);
        person3.requestBook(book5);
        person5.requestBook(book4);
        person4.requestBook(book2);

        librarianService.assignEngine(person1);
        // generate request pool
        librarianService.priorityRequestPool(person1);
        librarianService.priorityRequestPool(person2);
        librarianService.priorityRequestPool(person3);

        // issue books
        //librarianService.issueBook();

        /*
        #############
        once you made a class to implement another class
        by default all method in the implementing class
        becomes inaccessible to other class if not
        explicitly defined in the interface class
        as "public"
        #############
         */



    }
}