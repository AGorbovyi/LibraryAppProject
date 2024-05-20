package ui.button.book;

import service.Service;
import ui.FindBookMenu;
import ui.IMenu;
import ui.button.Button;
import ui.button.MenuCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author: Anton Gorbovyi
 * @version: 12.05.2024
 **/

public class FindBook extends Button  implements MenuCommand {

    private List<MenuCommand> menuCommands;
    private final IMenu menu;

    public FindBook(Service service, IMenu menu) {
        super.put(service.getClass().getSimpleName(), service);
        menuCommands = new ArrayList<>();
        this.menu=menu;
    }

    @Override
    public void executeCommand() {
        FindBookMenu findMenu = new FindBookMenu(super.getServices(), menu);
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
