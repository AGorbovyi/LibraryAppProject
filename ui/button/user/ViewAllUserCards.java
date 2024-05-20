package libraryapp.ui.button.user;

import java.util.List;

import libraryapp.service.UserCardService;
import libraryapp.ui.button.MenuCommand;
import main.java.libraryapp.ui.button.Button;

public class ViewAllUserCards extends Button  implements MenuCommand {

    public ViewAllUserCards(List<Service> services) {
        super(services);
    }

    @Override
    public void executeCommand() {
        UserCardService userCardService = super.getService(UserCardService.class);
        userCardService.print();
    }

    @Override
    public String getMenuName() {
        return "View all readers of the library";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}

