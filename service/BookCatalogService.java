package libraryapp.service;
/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author Boiko Yaroslav
 * @version 22-Apr-24
 */
import libraryapp.entity.Book;
import libraryapp.repository.BookCatalogRepository;

import java.util.ArrayList;
import java.util.List;

public class BookCatalogService extends Service<BookCatalogRepository> {

    public BookCatalogService(BookCatalogRepository repository) {
        super(repository, repository.getClass().getSimpleName());
    }

    public void addBook(String author, String bookTitle, String genre, String publisher) {
        Book book = new Book(author,  bookTitle,  genre,  publisher);
        super.getRepository().put(book);
        System.out.println("Book added: " + book);
    }


    public Book get(UUID bookID ) {
        return super.getRepository().get(bookID);
    }

    public boolean removeBook(UUID bookID) {
        Book delBook = super.getRepository().get(bookID);
        if (delBook != null) {
            super.getRepository().remove(catalogNumber);
            return true;
        }
        return false;
    }

    public List<Book> findBookByAuthor(String searchQuery) {
        List<Book> result = new ArrayList<>();

        for (Book book : super.getRepository().values()) {
            if (book.getAuthor().toLowerCase().contains(searchQuery.toLowerCase())) {
                result.add(book);
            }
        }

        if (result.isEmpty()) {
            System.out.println("No books found with this author: " + searchQuery);
        }

        return result;
    }

    public Book findByCatalogNumber(UUID bookID) {
        Book foundBook = super.getRepository().get(bookID);
        if (foundBook == null) {
            System.out.println("Book with this catalog number " + bookID + " not found.");
        }
        return foundBook;
    }
    public List<Book> findByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : super.getRepository().values()) {
            if (book.getBookTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        if (result.isEmpty()) {
            System.out.println("No books found with this title: " + title);
        }
        return result;
    }

    public void printCatalog () {
        super.getRepository().values().forEach(System.out::println);
    }
}
