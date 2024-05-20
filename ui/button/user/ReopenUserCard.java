package libraryapp.ui.button.user;

import java.util.List;

import libraryapp.service.UserCardService;
import libraryapp.service.util.UserInput;
import libraryapp.ui.button.MenuCommand;
import main.java.libraryapp.ui.button.Button;

public class ReopenUserCard  extends Button implements MenuCommand {

    public ReopenUserCard(List<Service> services) {
        super(services);
    }


    @Override
    public void executeCommand() {
        int userID=UserInput.getInt("Get User ID: ");
        UserCardService userCardService = super.getService(UserCardService.class);
        userCardService.reopenUserCard(userID);
    }

    @Override
    public String getMenuName() {
        return "Reopen Reader's Card";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}