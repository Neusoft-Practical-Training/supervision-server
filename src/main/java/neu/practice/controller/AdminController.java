package neu.practice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @PostMapping("/assign")
    public Result assign(){
        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("admin assign")
                .build();
        return result;
    }
}
