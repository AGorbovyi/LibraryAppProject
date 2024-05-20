package ui;

import service.BookCatalogService;
import service.Service;
import ui.button.Back;
import ui.button.ExitMenu;
import ui.button.MenuCommand;
import ui.button.book.AddBook;
import ui.button.book.FindBook;
import ui.button.book.RemoveBook;
import ui.button.book.ViewAllBooks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author: Anton Gorbovyi
 * @version: 12.05.2024
 **/
public class BookMenu implements IMenu {

    private List<MenuCommand> commands;
    private final String menuName;

    public BookMenu(HashMap<String, Service> services, IMenu menu) {
        this.menuName=this.getClass().getSimpleName();
        var menuCommands = new ArrayList<MenuCommand>();
        AddBook addBook = new AddBook(services.get(BookCatalogService.class.getSimpleName()));
        ViewAllBooks viewAllBooks = new ViewAllBooks(services.get(BookCatalogService.class.getSimpleName()));
        FindBook findBook = new FindBook(services.get(BookCatalogService.class.getSimpleName()), this);
        RemoveBook removeBook = new RemoveBook(services.get(BookCatalogService.class.getSimpleName()));
        Back back = new Back(services.get(BookCatalogService.class.getSimpleName()), menu);
        ExitMenu exitMenu = new ExitMenu();
        menuCommands.add(null);
        menuCommands.add(addBook);
        menuCommands.add(viewAllBooks);
        menuCommands.add(findBook);
        menuCommands.add(removeBook);
        menuCommands.add(back);
        menuCommands.add(exitMenu);
        this.commands = menuCommands;

    }

    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exitRequested = false;

        while (!exitRequested) {
            for (int i = 1; i < commands.size(); i++) {
                System.out.println("[" + i + "] " + commands.get(i).getMenuName());
            }
            System.out.println("Please make your choice: ");

            int userInput = scanner.nextInt();
            if (userInput < 0 || userInput >= commands.size()) {
                System.out.println("Invalid option, please try again.");
            }
            else {
                MenuCommand command = commands.get(userInput);
                command.executeCommand();
                exitRequested = command.shouldExit();
            }
        }
    }

    @Override
    public IMenu getMenu(String name) {
        if(this.getMenuName().equals(name))
            return this;
        return null;
    }

    @Override
    public String getMenuName() {
        return this.menuName;
    }
}
