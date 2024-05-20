package ui.button.book;

import service.BookCatalogService;
import service.Service;
import service.util.UserInput;
import ui.button.Button;
import ui.button.MenuCommand;

/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author: Anton Gorbovyi
 * @version: 12.05.2024
 **/

public class AddBook extends Button implements MenuCommand {
    private BookCatalogService service;
    public AddBook(Service service) {
        this.service= (BookCatalogService) service;
    }

    @Override
    public void executeCommand() {
        String author = UserInput.getText("Author: ");
        String bookTitle = UserInput.getText("Title: ");
        String genre = UserInput.getText("Genre: ");
        String publisher = UserInput.getText("Publisher: ");
        service.addBook(author, bookTitle, genre, publisher);
        System.out.println("Book added");
    }

    @Override
    public String getMenuName() {
        return "Add new book";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
