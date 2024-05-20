package libraryapp.ui.button.book;

import libraryapp.service.BookCatalogService;
import libraryapp.ui.FindBookMenu;
import libraryapp.ui.button.ExitMenu;
import libraryapp.ui.button.MenuCommand;
import main.java.libraryapp.ui.button.Button;

import java.util.ArrayList;
import java.util.List;

public class FindBook extends Button  implements MenuCommand {

    private List<MenuCommand> menuCommands;


    public FindBook(List<Service> services) {
        super(services);
        menuCommands = new ArrayList<MenuCommand>();
    }

    @Override
    public void executeCommand() {
        BookCatalogService bookCatalogService = super.getService(BookCatalogService.class);
        FindByAuthor author = new FindByAuthor(bookCatalogService);
        FindByTitle title = new FindByTitle(bookCatalogService);
        FindById id = new FindById(bookCatalogService);
        Back back = new Back(super.getServices(), this);
        ExitMenu exit = new ExitMenu();

        menuCommands.clear();
        menuCommands.add(null);
        menuCommands.add(author);
        menuCommands.add(title);
        menuCommands.add(id);
        menuCommands.add(back);
        menuCommands.add(exit);
        FindBookMenu findMenu = new FindBookMenu(menuCommands);
        findMenu.startMenu();
    }

    @Override
    public String getMenuName() {
        return "Find a book";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
