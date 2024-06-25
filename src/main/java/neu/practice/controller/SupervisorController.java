package neu.practice.controller;

import neu.practice.entity.Supervisor;
import neu.practice.entity.User;
import neu.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supervisor")
public class SupervisorController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody User user) {

        userService.register(user);

        System.out.println("supervisor = " + user);
        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("supervisor registered")
                .build();
        return result;
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user) {

        boolean flag = userService.updateById(user);
        if (flag) {
            System.out.println("Record updated successfully.");
        } else {
            System.out.println("Failed to update record.");
        }

        System.out.println("supervisor = " + user);
        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("supervisor registered")
                .build();
        return result;
    }

    @PostMapping("/feedback")
    public Result feedback() {

        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("supervisor feedback")
                .build();
        return result;
    }

    @PostMapping("/feedback_info/{page}")
    public Result feedbackInfo(@PathVariable int page) {

        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("supervisor feedback_info; page => " + page)
                .build();
        return result;
    }
}
