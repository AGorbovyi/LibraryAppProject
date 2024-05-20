package ui.button.book;

import entity.Book;
import service.BookCatalogService;
import service.Service;
import service.util.UserInput;
import ui.button.Button;
import ui.button.MenuCommand;

import java.util.List;

/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author: Anton Gorbovyi
 * @version: 12.05.2024
 **/
public class FindByAuthor extends Button implements MenuCommand {

    public FindByAuthor(Service service) {
        super.put(service.getClass().getSimpleName(), service);
    }

    @Override
    public void executeCommand() {
        String author = UserInput.getText("Enter author: ");
        BookCatalogService bookCatalogService= (BookCatalogService) super.getService(BookCatalogService.class.getSimpleName());
        List<Book> books = bookCatalogService.findBookByAuthor(author);
        if (books.size() > 0) {
            for (Book book : books) {
                System.out.println(book);
            }
        } else{
            System.out.println("No books by this author found");
        }
    }

    @Override
    public String getMenuName() {
        return "Find by Author";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}

