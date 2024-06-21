package neu.practice.serviceTest;

import neu.practice.entity.User;
import neu.practice.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    public void login() {
        User user = new User();
        user.setLogin_code("string");
        user.setPassword("string");
        User account = userService.login(user);
        System.out.println(account);
    }
}
