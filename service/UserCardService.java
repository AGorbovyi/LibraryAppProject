package libraryapp.service;
/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author Larysa Petrova
 * @version 17-Apr-24
 */

import java.util.UUID;

import libraryapp.entity.Book;
import libraryapp.entity.User;
import libraryapp.entity.UserCard;
import libraryapp.repository.UserCardRepository;

public class UserCardService extends Service<UserCardRepository>{

    public UserCardService(UserCardRepository repository) {
        super(repository, repository.getClass().getSimpleName());
    }

    public void addNewUserCard(String userName, String userSurname) {
        User user = new User(userName, userSurname);
        UserCard userCard = new UserCard(user);
        super.getRepository().put(userCard);
        System.out.println("User card added to repository: " + userCard);
    }

    public boolean updateUserCard(String name, String surname) {
        UserCard userCard = findUserCardByName(name);
        if (userCard != null) {
            userCard.getUser().setName(name);
            userCard.getUser().setSurname(surname);
            return true;
        }
        return false;
    }

    static boolean validateVarName(String varName) {
        // check variable name length
        if (varName.length() > 1) {
            System.out.println("Error: variable name is too long");
            return false;
        }
        if (varName.isEmpty()) {
            System.out.println("Error: variable name is empty");
            return false;
        }
        char firstChar = varName.charAt(0); // check if variable name in 'a'.'z'
        if (!(firstChar >= 'a' && firstChar <= 'z')) {
            System.out.println("Error: variable name is invalid ");
            return false;
        }
        return true;
    }

    public UserCard findUserCardByName(String name) {
        for (UserCard userCard : super.getRepository().values()) {
            if (userCard.getUser().getName().equalsIgnoreCase(name)) {
                System.out.println("UserCard found");
                return userCard;
            }
        }
        System.out.println("User card with name \"" + name + "\"is not found!");
        return null;
    }

    public UserCard findUserCardById(UUID userId) {
        UserCard userCard = super.getRepository().get(userId);
        if (userCard != null) {
            System.out.println("User card found! " + userCard);
        } else {
            System.out.println("User Card with ID " + userId + " not found");
        }
        return userCard;
    }

    public boolean closeUserCard(UUID userId) {
        UserCard userCard = super.getRepository().get(userId);
        if (userCard != null) {
            userCard.closeCard();
            return true;
        } else {
            System.out.println("UserCard with ID " + userId + " not found.");
            return false;
        }
    }

    public void reopenUserCard(UUID userId) {
        UserCard userCard = super.getRepository().get(userId);
        if (userCard != null) {
            userCard.reopenCard();
            System.out.println("UserCard with Id " + userId + " reopened.");
        } else {
            System.out.println("UserCard with ID " + userId + " not found.");
        }
    }

    public User findUserByBook(Book book) {
        for (UserCard userCard : super.getRepository().values()) {
            if (userCard.getUserBookList().contains(book)) {
                return userCard.getUser();
            }
        }
        return null;
    }

    public void print() {
        super.getRepository().values().forEach(System.out::println);
    }

}
