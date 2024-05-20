package libraryapp.ui.button.book;

import java.util.List;

import libraryapp.service.BookCatalogService;
import libraryapp.ui.button.MenuCommand;
import main.java.libraryapp.ui.button.Button;

public class ViewAllBooks extends Button  implements MenuCommand {

    public ViewAllBooks(List<Service> services) {
        super(services);
    }

    @Override
    public void executeCommand() {
        BookCatalogService bookCatalogService = super.getService(BookCatalogService.class);
        bookCatalogService.printCatalog();
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
