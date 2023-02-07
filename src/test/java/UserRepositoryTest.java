
import me.safuanov.User;
import me.safuanov.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class UserRepositoryTest {

    @Test
    void testEmptyList() {
        User artem = new User("", "");
        UserRepository userRepository = new UserRepository(artem);
        Optional<User> expected = Optional.empty();
        Optional<User> actual = userRepository.getAllUsers().stream().findAny();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testFullList() {
        User artem = new User("art", "12345");
        UserRepository userRepository = new UserRepository(artem);
        userRepository.addToList(artem);
        Optional<User> expected = Optional.of(artem);
        Optional<User> actual = userRepository.getAllUsers().stream().findAny();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void testSearchLoginNotMatch() {
        User artem = new User("Artem", "12345");
        UserRepository userRepository = new UserRepository(artem);
        userRepository.addToList(artem);
        Optional<User> expected = userRepository.searchLogin("Art");
        Optional<User> actual = Optional.of(artem);
        Assertions.assertNotEquals(expected,actual);
    }

    @Test
    void testSearchLoginMatch() {
        User artem = new User("Artem", "12345");
        UserRepository userRepository = new UserRepository(artem);
        userRepository.addToList(artem);
        Optional<User> expected = userRepository.searchLogin("Artem");
        Optional<User> actual = Optional.of(artem);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void testSearchLoginAndPasswordMatch() {
        User artem = new User("Artem", "12345");
        UserRepository userRepository = new UserRepository(artem);
        userRepository.addToList(artem);
        Optional<User> expected = userRepository.searchLoginAndPassword("Artem", "12345");
        Optional<User> actual = Optional.of(artem);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void testSearchLoginAndPasswordLoginNotMatch() {
        User artem = new User("Artem", "12345");
        UserRepository userRepository = new UserRepository(artem);
        userRepository.addToList(artem);
        Optional<User> expected = userRepository.searchLoginAndPassword("Arte", "12345");
        Optional<User> actual = Optional.of(artem);
        Assertions.assertNotEquals(expected,actual);
    }
    @Test
    void testSearchLoginAndPasswordPasswordNotMatch() {
        User artem = new User("Artem", "12345");
        UserRepository userRepository = new UserRepository(artem);
        userRepository.addToList(artem);
        Optional<User> expected = userRepository.searchLoginAndPassword("Artem", "1234");
        Optional<User> actual = Optional.of(artem);
        Assertions.assertNotEquals(expected,actual);
    }
}
