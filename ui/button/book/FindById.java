package ui.button.book;

import entity.Book;
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
public class FindById extends Button  implements MenuCommand {

    public FindById(Service service) {
        super.put(service.getClass().getSimpleName(), service);
    }

    @Override
    public void executeCommand() {
        String id = UserInput.getText("Enter book ID: ");
        BookCatalogService bookCatalogService= (BookCatalogService) super.getService(BookCatalogService.class.getSimpleName());
        UUID uid = UUID.fromString(id);
        Book book = bookCatalogService.findByCatalogNumber(uid);
        if (book != null) {
            System.out.println(book);
        } else{
            System.out.println("No book with this ID found");
        }
    }

    @Override
    public String getMenuName() {
        return "Find by ID";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
