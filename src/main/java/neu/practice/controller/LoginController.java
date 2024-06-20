package neu.practice.controller;

import neu.practice.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        System.out.println("user = " + user);
        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("login controller")
                .build();
        return result;
    }

    ;
}
