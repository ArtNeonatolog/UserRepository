
import me.safuanov.User;
import me.safuanov.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserRepositoryTest {
    @Test
    void testEmptyList() {
        UserRepository userRepository = new UserRepository(new User("", ""));
        Assertions.assertTrue(userRepository.getAllUsers().isEmpty());
    }

    @Test
    void testFullList() {
        UserRepository userRepository = new UserRepository(new User("Artem", "12345"));
        Assertions.assertNotNull(userRepository.getAllUsers());
    }

    @Test
    void testSearchLoginTrue() {
        UserRepository userRepository = new UserRepository(new User("Artem", "12345"));
        Assertions.assertEquals(userRepository.searchLogin(userRepository.getUser().getLogin()).get(), userRepository.getUser());
    }
}
