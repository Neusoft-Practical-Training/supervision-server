package neu.practice.controller;

import neu.practice.entity.Supervisor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supervisor")
public class SupervisorController {
    @PostMapping("/register")
    public Result register(@RequestBody Supervisor supervisor) {
        System.out.println("supervisor = " + supervisor);
        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("supervisor registered")
                .build();
        return result;
    }

    @PostMapping("/update")
    public Result update(@RequestBody Supervisor supervisor) {
        System.out.println("supervisor = " + supervisor);
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
