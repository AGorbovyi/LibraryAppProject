package ui.button.book;

import service.BookCatalogService;
import service.Service;
import ui.button.Button;
import ui.button.MenuCommand;

/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author: Anton Gorbovyi
 * @version: 12.05.2024
 **/
public class ViewAllBooks extends Button  implements MenuCommand {

    private BookCatalogService service;
    public ViewAllBooks(Service service) {
        this.service= (BookCatalogService) service;
    }

    @Override
    public void executeCommand() {
        service.printCatalog();
    }

    @Override
    public String getMenuName() {
        return "View all books in catalog";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
