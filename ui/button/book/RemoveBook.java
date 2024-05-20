package ui.button.book;

import service.BookCatalogService;
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
public class RemoveBook extends Button  implements MenuCommand {

    private BookCatalogService service;
    public RemoveBook(Service service) {
        this.service= (BookCatalogService) service;
    }

    @Override
    public void executeCommand() {
        String bookCatalogNumberRemove = UserInput.getText("Enter book catalog number: ");
        UUID uid = UUID.fromString(bookCatalogNumberRemove);
        boolean remove = service.removeBook(uid);
        if (remove) {
            System.out.println("Book was removed from catalog");
        } else {
            System.out.println("Book with catalog number" + bookCatalogNumberRemove + " was not found!");
        }
    }

    @Override
    public String getMenuName() {
        return "Remove book from catalog";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
