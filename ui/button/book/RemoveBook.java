package libraryapp.ui.button.book;

import java.util.List;

import libraryapp.service.BookCatalogService;
import libraryapp.service.util.UserInput;
import libraryapp.ui.button.MenuCommand;
import main.java.libraryapp.ui.button.Button;

public class RemoveBook extends Button  implements MenuCommand {

    public RemoveBook(List<Service> services) {
        super(services);
    }

    @Override
    public void executeCommand() {
        int bookCatalogNumberRemove = UserInput.getInt("Enter book catalog number: ");
        BookCatalogService bookCatalogService = super.getService(BookCatalogService.class);
        boolean remove = bookCatalogService.removeBook(bookCatalogNumberRemove);
        if (remove) {
            System.out.println("Book was removed from catalog");
        } else {
            System.out.println("Book was not removed");
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
