package libraryapp.ui.button.library;

import java.util.List;

/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author: Anton Gorbovyi
 * @version: 22.04.2024
 **/

import libraryapp.service.LibraryService;
import libraryapp.service.util.UserInput;
import libraryapp.ui.button.MenuCommand;
import main.java.libraryapp.ui.button.Button;

public class BorrowBook extends Button  implements MenuCommand {

    public BorrowBook(List<Service> services) {
        super(services);
    }

    @Override
    public void executeCommand() {
        int bookId = UserInput.getInt("Book catalog number to be borrowed to the reader: ");
        int userId = UserInput.getInt("Card ID of the user who borrows a book: ");
        LibraryService libraryService = new LibraryService(super.getServices());
        libraryService.borrowBookFromLibrary(bookId, userId);
    }

    @Override
    public String getMenuName() {
        return "Borrow Book";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
