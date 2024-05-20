package service;

import entity.Book;
import entity.BookInfo;
import entity.User;
import entity.UserCard;
import repository.BookCatalogRepository;
import repository.CrudRepository;
import repository.UserCardRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.UUID;

/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author Boiko Yaroslav
 * @version 22-Apr-24
 */

public class LibraryService extends Service<CrudRepository, String, UserCardService> implements IService<CrudRepository, String, UserCardService>{

    public LibraryService(HashMap<String, CrudRepository> repositories) {
        super(repositories);
    }

    public void borrowBookFromLibrary(UUID bookId, UUID userCardId) {
        UserCardRepository userRepo = (UserCardRepository) super.getRepository(UserCardRepository.class.getSimpleName());
        BookCatalogRepository bookRepo = (BookCatalogRepository) super.getRepository(BookCatalogRepository.class.getSimpleName());
        Book book = bookRepo.get(bookId);
        if (book != null) {
            BookInfo bookInfo = book.getBookInfo();
            if (bookInfo == null){
                bookInfo = new BookInfo();
            }
            if (!bookInfo.isInLibrary()) {
                if (bookInfo.getBorrowedTo().equals(userCardId)) {
                    System.out.println("This book is already borrowed to the same reader.");
                } else {
                    System.out.println("This book is already borrowed to another reader.");
                }
            } else {

                UserCard userCard = userRepo.get(userCardId);
                if (userCard != null && userCard.getUserBorrowedBooks().size() >= userCard.getMaxBooksLimit()) {
                    System.out.println("You have reached the maximum limit of borrowed books.");
                    return;
                }
                bookInfo.setInLibrary(false);
                bookInfo.setBorrowedTo(userCardId);
                bookInfo.setBorrowedDuration(14);
                bookInfo.setBorrowedDate(LocalDate.now());
                bookInfo.getReturnDate();
                book.setBookInfo(bookInfo);
                User user = userCard.getUser();
                userCard.borrowBook(book);
                System.out.println("Book '" + book.getBookTitle() + "' by " + book.getAuthor() + " has been borrowed by " + user.getUserFullName() + ".");
            }
        } else {
            System.out.println("Book with catalog number " + bookId + " is not available in the library.");
        }
    }

    public void returnBookToLibrary(UUID bookId) {
        UserCardRepository userRepo = (UserCardRepository) super.getRepository(UserCardRepository.class.getSimpleName());
        BookCatalogRepository bookRepo = (BookCatalogRepository) super.getRepository(BookCatalogRepository.class.getSimpleName());
        Book book = bookRepo.get(bookId);
        if (book != null) {
            BookInfo bookInfo = book.getBookInfo();
            if (bookInfo == null) System.out.println("There are no activities with this book!");
            bookInfo.setInLibrary(true);
            UserCard userCard = userRepo.get(bookInfo.getBorrowedTo());
            userCard.returnBook(book);
            System.out.println("Book '" + book.getBookTitle() + "' by " + book.getAuthor() + " has been returned.");
        } else {
            System.out.println("Book with catalog number " + bookId + " is not available in the library.");
        }
    }
}