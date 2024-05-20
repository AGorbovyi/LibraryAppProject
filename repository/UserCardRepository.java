package libraryapp.repository;
/**
 * AIT-TR, cohort 42.1, Java Basic, Project1
 *
 * @author Larysa Petrova
 * @version 21-Apr-24
 **/

import libraryapp.entity.User;
import libraryapp.entity.UserCard;

import java.util.*;

public class UserCardRepository implements CrudRepository<Integer, UserCard> {
    private final Map<Integer, UserCard> userCards;

    public UserCardRepository() {
        this.userCards = new HashMap<>();
    }

    @Override
    public void put(UserCard value) {
        userCards.put(value.getUserId(), value);
    }

    @Override
    public UserCard get(UUID key) {
        for (UserCard card : userCards.values()) {
            if (card.getUserId() == key) {
                return card;
            }
        }
        return null;
    }

    @Override
    public void remove(UUID key) {
        for (int i = 0; i < userCards.size(); i++) {
            if (userCards.get(i).getUserId() == key) {
                userCards.remove(i);
            }
        }
    }

    @Override
    public Collection<UserCard> values() {
        return userCards.values();
    }
//    public Iterable<Object> findAll() {
//        return Collections.singleton(userCards.values());
//    }

    public void init() {
        List<User> usersList = new ArrayList<>(List.of(
                new User("Anton", "Gorbovyi"),
                new User("Halyna", "Potyvaieve"),
                new User("Yaroslav", "Boiko"),
                new User("Larysa", "Petrova"),
                new User("Andrey", "Shishkov")
        ));
        for (User user : usersList) {
            UserCard card = new UserCard(user);
            this.put(card);
        }
    }
}


