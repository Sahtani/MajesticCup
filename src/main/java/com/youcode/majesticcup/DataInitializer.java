
import com.youcode.majesticcup.shared.security.UsernameAlreadyExistsException;
import com.youcode.majesticcup.shared.security.dto.CreateUserDto;
import com.youcode.majesticcup.shared.security.mapper.UserMapper;
import com.youcode.majesticcup.shared.security.model.Role;
import com.youcode.majesticcup.shared.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public void run(String... args) {
        createInitialUsers();
    }

    private void createInitialUsers() {
        createUserIfNotExists("admin", "adminpass", "ADMIN");
        createUserIfNotExists("operator", "operatorpass", "OPERATOR");
    }

    private void createUserIfNotExists(String username, String password, String role) {
        try {
            // Création correcte d'un record CreateUserDto
            CreateUserDto userDto = new CreateUserDto(username, password, Role.valueOf(role));

            userService.createUser(userDto);
        } catch (UsernameAlreadyExistsException e) {
            // Log que l'utilisateur existe déjà
            System.out.println("User " + username + " already exists. Skipping creation.");
        }
    }
}
