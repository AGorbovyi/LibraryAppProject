package ui.button.user;

import service.Service;
import service.UserCardService;
import service.util.UserInput;
import ui.button.Button;
import ui.button.MenuCommand;

import java.util.UUID;

/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author: Anton Gorbovyi
 * @version: 12.05.2024
 **/
public class CloseUserCard extends Button  implements MenuCommand {

    public CloseUserCard(Service service) {
        super.put(service.getClass().getSimpleName(), service);
    }


    @Override
    public void executeCommand() {
        String userID=UserInput.getText("Enter reader ID: ");
        var uid = UUID.fromString(userID);
        UserCardService userCardService = (UserCardService) super.getService(UserCardService.class.getSimpleName());
        boolean ok = userCardService.closeUserCard(uid);
        if (ok) {
            System.out.println("Reader's card is successfully closed!");
        } else {
            System.out.println("Reader's card is not closed!");
        }
    }

    @Override
    public String getMenuName() {
        return "Close reader's card";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}