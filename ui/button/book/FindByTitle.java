package libraryapp.ui.button.book;

import libraryapp.entity.Book;
import libraryapp.service.BookCatalogService;
import libraryapp.service.util.UserInput;
import libraryapp.ui.button.MenuCommand;
import main.java.libraryapp.ui.button.Button;

import java.util.List;

public class FindByTitle extends Button  implements MenuCommand {

    public FindByTitle(List<Service> services) {
        super(services);
    }

    @Override
    public void executeCommand() {
        String title = UserInput.getText("Enter book title: ");
        BookCatalogService bookCatalogService = super.getService(BookCatalogService.class);
        List<Book> books = bookCatalogService.findByTitle(title);
        if (books.size() > 0) {
            for (Book book : books) {
                System.out.println(book);
            }
        } else{
            System.out.println("No book with this title found");
        }
    }

    @Override
    public String getMenuName() {
        return "Find by Title";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
