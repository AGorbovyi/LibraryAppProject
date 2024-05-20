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

public class FindUserCardByName extends Button  implements MenuCommand {

    public FindUserCardByName(List<Service> services) {
        super(services);
        }


    @Override
    public void executeCommand() {
        String userName=UserInput.getText("Get User Name: ");
        UserCardService userCardService = super.getService(UserCardService.class);
        userCardService.findUserCardByName(userName);
    }

    @Override
    public String getMenuName() {
        return "Find User Card by Name";
    }

    @Override
    public boolean shouldExit() {
        return false;
    }
}
