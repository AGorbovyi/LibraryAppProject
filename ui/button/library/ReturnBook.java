package ui.button.library;

import service.LibraryService;
import service.Service;
import service.util.UserInput;
import ui.button.Button;
import ui.button.MenuCommand;

import java.util.UUID;

/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author: Anton Gorbovyi
 * @version: 12.05.2024
 **/
public class ReturnBook extends Button  implements MenuCommand {

    public ReturnBook(Service service) {
        super.put(service.getClass().getSimpleName(), service);
    }

    @Override
    public void executeCommand() {
        String bookId = UserInput.getText("Book catalog number for return to the library: ");
        var bookUid = UUID.fromString(bookId);
        LibraryService libraryService = (LibraryService) super.getService(LibraryService.class.getSimpleName());
        libraryService.returnBookToLibrary(bookUid);
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
