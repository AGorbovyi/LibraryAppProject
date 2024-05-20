package libraryapp.repository;

import libraryapp.entity.Book;

import java.util.*;
/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author Boiko Yaroslav
 * @version 22-Apr-24
 */
public class BookCatalogRepository implements CrudRepository<Integer, Book> {
    private Map<Integer, Book> bookMap;

    public BookCatalogRepository () {
        bookMap = new HashMap<>();
    }

    public Map<Integer, Book> getBookMap() {
        return bookMap;
    }


    @Override
    public void put (Book book) {
        int id = bookMap.size()+1;
        bookMap.put(id, book);
    }

    @Override
    public Book get(UUID bookID) {
        return bookMap.get(bookID);
    }

    @Override
    public void remove(UUID bookID) {
        bookMap.remove(bookID);
    }

    @Override
    public Collection<Book> values() {
        return bookMap.values();
    }

    public void init() {
        List<Book> books = new ArrayList<>(List.of(
                new Book("Taras Shevchenko", "Kobzar", "Poetry", "Kyiv Old Guard"),
                new Book("Ivan Franko", "Za dvoma zaitsiamy", "Drama", "Lviv Printing House"),
                new Book("Lesia Ukrainka", "Lisova pisnia", "Poetry", "Kyiv Old Guard"),
                new Book("Ivan Nechuy-Levytsky", "Pіznorid", "Novel", "Kyiv Old Guard"),
                new Book("Mykhailo Kotsiubynsky", "Intermezzo", "Novel", "Kyiv Old Guard"),
                new Book("Panas Myrny", "Pisni smutku", "Novel", "Lviv Printing House"),
                new Book("Ivan Franko", "Pisni smіlі", "Poetry", "Kyiv Old Guard"),
                new Book("Lesia Ukrainka", "Kaminnyi hospodar", "Drama", "Lviv Printing House"),
                new Book("Pavlo Tychyna", "Pluh", "Poetry", "Kyiv Old Guard")
        ));
        books.forEach(book -> put(book));
    }
}