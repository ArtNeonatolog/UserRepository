import me.safuanov.UserRepository;
import me.safuanov.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;

    @Test
    void whenRepositoryIsEmptyThenShouldBeEmptyList() {
        when(userRepository.getAllUsers()).thenReturn(List.of());
        Assertions.assertEquals(userService.getUserRepository().getAllUsers().stream().findAny(), Optional.empty());
    }
}
