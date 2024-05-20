package libraryapp.ui.button;

import libraryapp.ui.AdminMenu;
import libraryapp.ui.BookMenu;
import main.java.libraryapp.ui.IMenu;
import main.java.libraryapp.ui.button.Button;

public class Back extends Button implements MenuCommand {
    private IMenu menu;

    public Back(List<Service> services, IMenu menu) {
        super(services);
        this.menu = menu;
    }

    @Override
    public void executeCommand() {
        menu.startMenu();
    }

    @Override
    public String getMenuName() {
        return "Back";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
