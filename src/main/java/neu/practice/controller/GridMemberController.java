package neu.practice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grid_member")
public class GridMemberController {
    @PostMapping("/confirm")
    public Result confirm() {
        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("grid_member confirm")
                .build();
        return result;
    }
}
