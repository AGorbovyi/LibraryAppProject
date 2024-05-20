package libraryapp.ui.button.book;

import libraryapp.entity.Book;
import libraryapp.service.BookCatalogService;
import libraryapp.service.util.UserInput;
import libraryapp.ui.button.MenuCommand;
import main.java.libraryapp.ui.button.Button;

import java.util.List;

public class FindByAuthor extends Button implements MenuCommand {

    public FindByAuthor(List<Service> services) {
        super(services);
    }

    @Override
    public void executeCommand() {
        String author = UserInput.getText("Enter author: ");
        BookCatalogService bookCatalogService=super.getService(BookCatalogService.class);
        List<Book> books = bookCatalogService.findBookByAuthor(author);
        if (books.size() > 0) {
            for (Book book : books) {
                System.out.println(book);
            }
        } else{
            System.out.println("No book with this author found");
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

