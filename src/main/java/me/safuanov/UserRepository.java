package me.safuanov;

import java.util.*;

public class UserRepository {
    private final User user;
    private final List<User> userList = new ArrayList<>();

    public UserRepository(User user) {
            this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void addToList (User user) {

        userList.add(user);
    }

    public Optional<User> searchLogin (String login) {
        return this.userList.stream().filter(user -> user.getLogin().equals(login)).findAny();
    }

    public Optional<User> searchLoginAndPassword (String login, String password) {
        return this.userList.stream().filter(user -> user.getLogin().equals(login)).filter(user -> user.getPassword().equals(password)).findAny();
    }

    public Collection<User> getAllUsers () {
            return Collections.unmodifiableCollection(userList);
        }
}
