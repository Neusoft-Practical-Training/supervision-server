package neu.practice.controllerTest;

import neu.practice.controller.LoginController;
import neu.practice.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserControllerTest {
    @Autowired
    LoginController loginController;
    @Test
    public void addTest() {
        User user = new User();
        user.setLogin_code("string");
        user.setPassword("string");
        user.setTel("12345678910");
        user.setName("string");
        user.setGender(1);
        user.setRole(1);
        user.setAge(20);
        user.setRemarks("some remarks");
        user.setStatus(1);
        user.setAvatar("avatar.png");
        user.setCreate_time("2024-06-21 12:00:00");
        user.setUpdate_time("2024-06-21 12:00:00");
        loginController.register(user);
    }
}
