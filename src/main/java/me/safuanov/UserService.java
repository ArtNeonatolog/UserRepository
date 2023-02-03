package me.safuanov;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return this.userRepository;
    }

    public void newUser(String login, String password) {
        User user = new User(login, password);
        if (userRepository.searchLogin(login).equals(Optional.empty())) {
           throw new UserNonUniqueException("Пользовтель с таким логином уже существует!");
       }
        if (login == null || login.isBlank() || password == null || password.isBlank()) {
            throw new IllegalArgumentException("Логин и пароль не должны быть пустыми или равными null!");
        }
        this.userRepository.addToList(user);
    }

    public List<String> getAllLoginsToList () {
        return this.userRepository.getAllUsers().stream().map(User::getLogin).collect(Collectors.toList());
    }
}
