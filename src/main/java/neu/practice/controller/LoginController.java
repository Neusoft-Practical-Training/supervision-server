package neu.practice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import neu.practice.entity.User;
import neu.practice.mapper.UserMapper;
import neu.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        userService.login(user);

        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("login controller")
                .build();
        return result;
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        userService.register(user);

        return null;
    }


}
