package neu.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aqi")
public class AqiController {
    @GetMapping
    public Result getAQI() {
        Result result = Result.builder()
                .code(1)
                .data(null)
                .message("get aqi")
                .build();
        return result;
    }
}
