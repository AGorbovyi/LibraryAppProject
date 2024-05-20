package libraryapp.ui.button.user;

import java.util.List;

/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author: Anton Gorbovyi
 * @version: 22.04.2024
 **/

import libraryapp.service.UserCardService;
import libraryapp.service.util.UserInput;
import libraryapp.ui.button.MenuCommand;
import main.java.libraryapp.ui.button.Button;

public class FindUserCardByID extends Button  implements MenuCommand {

    public FindUserCardByID(List<Service> services) {
        super(services);
    }


    @Override
    public void executeCommand() {
        int userID=UserInput.getInt("Get User ID: ");
        UserCardService userCardService = super.getService(UserCardService.class);
        userCardService.findUserCardById(userID);
    }

    @Override
    public String getMenuName() {
        return "Find User Card by ID";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}