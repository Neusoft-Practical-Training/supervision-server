package neu.practice.controllerTest;

import jakarta.annotation.Resource;
import neu.practice.controller.LoginController;
import neu.practice.controller.SupervisorController;
import neu.practice.entity.User;
import neu.practice.mapper.UserMapper;
import neu.practice.service.UserService;
import neu.practice.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserControllerTest {
    @Autowired
    LoginController loginController;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SupervisorController supervisorController;

    @Test
    public void addTest() {
        User user = new User();
        user.setLogin_code("admin");
        user.setPassword("123456");
        user.setTel("12345678910");
        user.setName("string");
        user.setGender(1);
        user.setRole(2);
        user.setAge(20);
        user.setRemarks("some remarks");
        user.setStatus(1);
        user.setAvatar("avatar.png");
        user.setCreate_time("2024-06-21 12:00:00");
        user.setUpdate_time("2024-06-21 12:00:00");
        supervisorController.register(user);
    }
    @Test
    public void loginTest() {
        User user = new User();
        user.setLogin_code("admin");
        user.setPassword("123456");
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
        loginController.login(user);

    }
}
