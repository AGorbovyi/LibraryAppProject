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
public class FindUserCardById extends Button  implements MenuCommand {

    public FindUserCardById(Service service) {
        super.put(service.getClass().getSimpleName(),service);
    }


    @Override
    public void executeCommand() {
        String userId=UserInput.getText("Enter reader ID: ");
        var uid = UUID.fromString(userId);
        UserCardService userCardService = (UserCardService) super.getService(UserCardService.class.getSimpleName());
        userCardService.findUserCardById(uid);
    }

    @Override
    public String getMenuName() {
        return "Find reader card by ID";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}