package libraryapp.ui.button.book;

import java.util.List;

import libraryapp.entity.Book;
import libraryapp.service.BookCatalogService;
import libraryapp.service.util.UserInput;
import libraryapp.ui.button.MenuCommand;
import main.java.libraryapp.ui.button.Button;

public class FindById extends Button  implements MenuCommand {

    public FindById(List<Service> services) {
        super(services);
    }

    @Override
    public void executeCommand() {
        int id = UserInput.getInt("Enter book ID: ");
        BookCatalogService bookCatalogService = super.getService(BookCatalogService.class);
        Book book = bookCatalogService.findByCatalogNumber(id);
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
