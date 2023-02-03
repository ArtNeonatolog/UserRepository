package me.safuanov;

import java.util.*;

public class UserRepository {
    private final User user = new User(getUser().getLogin(), getUser().getPassword());

    private final Optional<User> optionalUser = Optional.of(user);

    private final List<User> userList = new ArrayList<>();
    public User getUser() {

        return user;
    }

    public void addToList (User user) {
        userList.add(user);
    }

    public Optional<User> searchLogin (String login) {
        if (optionalUser.stream().anyMatch(user -> user.getLogin().equals(login))){
            return optionalUser;
        }
        return Optional.empty();
    }

    public Optional<User> searchLoginAndPassword (String login, String password) {
        if (optionalUser.stream().allMatch(user -> user.getLogin().equals(login)) &&
                optionalUser.stream().allMatch(user -> user.getPassword().equals(password))){
            return optionalUser;
        }
        return Optional.empty();
    }

    public Collection<User> getAllUsers () {
        return Collections.unmodifiableCollection(userList);
    }

}
