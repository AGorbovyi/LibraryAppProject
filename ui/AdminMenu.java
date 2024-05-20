package libraryapp.ui;

/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author: Anton Gorbovyi
 * @version: 22.04.2024
 **/

import libraryapp.service.BookCatalogService;
import libraryapp.service.LibraryService;
import libraryapp.service.UserCardService;
import libraryapp.service.util.UserInput;
import libraryapp.ui.button.Back;
import libraryapp.ui.button.ExitMenu;
import libraryapp.ui.button.MenuCommand;
import libraryapp.ui.button.book.*;
import libraryapp.ui.button.library.BorrowBook;
import libraryapp.ui.button.library.ReturnBook;
import libraryapp.ui.button.user.*;
import libraryapp.ui.button.user.ViewAllUserCards;
import main.java.libraryapp.ui.IMenu;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

public class AdminMenu implements IMenu{

    ExitMenu exitMenu;
    Back back;
    private List<MenuCommand> menuCommands;
    private List<Service> services;

    public AdminMenu(List<Service> services) {
        this.exitMenu = new ExitMenu();
        this.services = services;
        this.menuCommands = new ArrayList<>();
    }

    public void startMenu () {

        System.out.println("=====================");
        System.out.println("**** App menu: ****");
        System.out.println("=====================");
        System.out.println("[1] Book menu");
        System.out.println("[2] Reader menu");
        System.out.println("[3] Library menu");
        System.out.println("[4] " + this.exitMenu.getMenuName());
        System.out.println("=====================");

        int menuItem = UserInput.getInt("Please select menu item: ");

        switch (menuItem) {
            case 1:
                AddBook addBook = new AddBook(services);
                ViewAllBooks viewAllBooks = new ViewAllBooks(services);
                FindBook findBook = new FindBook(services);
                RemoveBook removeBook = new RemoveBook(services);
                back = new Back(services,this);
                menuCommands.clear();
                menuCommands.add(null);
                menuCommands.add(addBook);
                menuCommands.add(viewAllBooks);
                menuCommands.add(findBook);
                menuCommands.add(removeBook);
                menuCommands.add(back);
                menuCommands.add(exitMenu);
                BookMenu bookMenu = new BookMenu(menuCommands);
                bookMenu.startMenu();
                break;
            case 2:
                AddUserCard addUserCard = new AddUserCard(services);
                UpdateUserCard updateUserCard = new UpdateUserCard(services);
                ViewAllUserCards viewAllUserCards = new ViewAllUserCards(services);
                FindUserCardByID findUserCardById = new FindUserCardByID(services);
                FindUserCardByName findUserCardByNames = new FindUserCardByName(services);
                CloseUserCard closeUserCard = new CloseUserCard(services);
                ReopenUserCard reopenCard = new ReopenUserCard(services);
                back = new Back(services,this);
                menuCommands.clear();
                menuCommands.add(null);
                menuCommands.add(addUserCard);
                menuCommands.add(updateUserCard);
                menuCommands.add(viewAllUserCards);
                menuCommands.add(findUserCardById);
                menuCommands.add(findUserCardByNames);
                menuCommands.add(closeUserCard);
                menuCommands.add(reopenCard);
                menuCommands.add(back);
                menuCommands.add(exitMenu);
                UserCardMenu userCardMenu = new UserCardMenu(menuCommands);
                userCardMenu.startMenu();
                break;
            case 3:
                BorrowBook borrow = new BorrowBook(services);
                ReturnBook returnBook = new ReturnBook(services);
                back = new Back(services,this);
                menuCommands.clear();
                menuCommands.add(null);
                menuCommands.add(borrow);
                menuCommands.add(returnBook);
                menuCommands.add(back);
                menuCommands.add(exitMenu);
                LibraryMenu libraryMenu = new LibraryMenu(menuCommands);
                libraryMenu.startMenu();
                break;
            case 4:
                this.exitMenu.executeCommand();
                break;
            default:
                System.out.println("Invalid menu item, please try again!");
        }
    }

}
