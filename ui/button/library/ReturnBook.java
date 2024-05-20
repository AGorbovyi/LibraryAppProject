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

public class ReturnBook extends Button  implements MenuCommand {

    public ReturnBook(List<Service> services) {
        super(services);
    }

    @Override
    public void executeCommand() {
        int bookId = UserInput.getInt("Book catalog number for return to the library: ");
        LibraryService libraryService = new LibraryService(super.getServices());
        libraryService.returnBookToLibrary(bookId);
    }

    @Override
    public String getMenuName() {
        return "Return Book";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
