package libraryapp.service;

import libraryapp.entity.Book;
import libraryapp.entity.BookInfo;
import libraryapp.entity.User;
import libraryapp.entity.UserCard;
import libraryapp.repository.BookCatalogRepository;
import libraryapp.repository.UserCardRepository;
import libraryapp.service.util.UserInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author Boiko Yaroslav
 * @version 22-Apr-24
 */

public class LibraryService {
    public List<Service> services;

    public LibraryService(List<Service> services) {
        this.services = services;
    }

    public boolean borrowBookFromLibrary(UUID bookID, UUID userCardID) {
        BookCatalogService catalogService;
        UserCardService userCardService;
        for (Service service : services){
            if (service instanceof BookCatalogService) catalogService = (BookCatalogService) service;
            if (service instanceof UserCardService) userCardService = (UserCardService) service;
        }
        Book book = catalogService.getBook(bookID);
        if (book != null) {
            BookInfo bookInfo = book.getBookInfo();
            if (bookInfo == null){
                bookInfo=new BookInfo();
            }
            if (!bookInfo.isInLibrary()) {
                if (bookInfo.getBorrowedTo() == userCardID) {
                    System.out.println("This book is already borrowed to the same reader.");
                }
                else
                    System.out.println("This book is already borrowed to another reader.");
                return false;
            } else {
                bookInfo.setInLibrary(false);
                bookInfo.setBorrowedTo(userCardID);
                bookInfo.setBorrowedDuration(14);
                bookInfo.setBorrowedDate(LocalDate.now());
                book.setBookInfo(bookInfo);
                UserCard userCard = userCardService.getUserCard(userCardID);
                User user = userCardService.findUserCardById(userCardID);
                userCard.borrowBook(book);
                System.out.println("Book '" + book.getBookTitle() + "' by " + book.getAuthor() + " has been borrowed by " + user.getUserFullName() + ".");
                return true;
            }
        } else {
            System.out.println("Book with catalog number " + catalogNumber + " is not available in the library.");
            return false;
        }
    }

    public void returnBookToLibrary(UUID bookID) {
        BookCatalogService catalogService;
        UserCardService userCardService;
        for (Service service : services){
            if (service instanceof BookCatalogService) catalogService = (BookCatalogService) service;
            if (service instanceof UserCardService) userCardService = (UserCardService) service;
        }
        Book book = catalogService.get(bookID);
        if (book != null) {
            BookInfo bookInfo = book.getBookInfo();
            if (bookInfo == null) System.out.println("There are no activities with this book!");
            bookInfo.setInLibrary(true);
            UserCard userCard = userCardService.getUserCard(bookInfo.getBorrowedTo());
            userCard.returnBookToLibrary(book);
            System.out.println("Book '" + book.getBookTitle() + "' by " + book.getAuthor() + " has been returned.");
        } else {
            System.out.println("Book with catalog number " + catalogNumber + " is not available in the library.");
        }
    }
}