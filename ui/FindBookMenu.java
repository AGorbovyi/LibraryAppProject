package libraryapp.ui;

/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author: Anton Gorbovyi
 * @version: 22.04.2024
 **/

import libraryapp.ui.button.ExitMenu;
import libraryapp.ui.button.MenuCommand;
import main.java.libraryapp.ui.IMenu;

import java.util.List;
import java.util.Scanner;

public class FindBookMenu implements IMenu{

    ExitMenu exitMenu;

    private final List<MenuCommand> commands;

    public FindBookMenu(List<MenuCommand> commands) {
        this.commands = commands;
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
            } else {
                MenuCommand command = commands.get(userInput);
                command.executeCommand();
                exitRequested = command.shouldExit();
            }
        }
    }

}
